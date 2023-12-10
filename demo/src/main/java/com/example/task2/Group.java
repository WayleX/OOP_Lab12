package com.example.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks;

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task: tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        for (Task<T> task: Collections.unmodifiableList(tasks)) {
            task.apply(arg);
        }
    }

    @Override
    public void stamp(Visitor<T> visitor) {
        Map<String, String> start = visitor.GroupStart(this);
        this.setHeader("groupStart", start.get("groupStart"));

        for(Task<T> task: tasks){
            task.stamp(visitor);
        }

        Map<String, String> end = visitor.GroupEnd(this);
        this.setHeader("groupEnd", end.get("groupEnd"));
    }

}
