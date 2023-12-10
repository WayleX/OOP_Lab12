package com.example.task2;


import java.util.Map;
import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    @Override
    public void stamp(Visitor<T> visitor) {
        Map<String, String> sign = visitor.Signature(this);
        this.setHeader("signature", sign.get("signature"));
    }
}
