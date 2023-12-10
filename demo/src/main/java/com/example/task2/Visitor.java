package com.example.task2;

import java.util.Map;

public interface Visitor<T> {
    Map<String, String> Signature(Task<T> task);
    Map<String, String> GroupStart(Task<T> task);
    Map<String, String> GroupEnd(Task<T> task);
}
