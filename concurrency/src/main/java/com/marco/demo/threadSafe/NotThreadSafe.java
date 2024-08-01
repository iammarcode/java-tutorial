package com.marco.demo.threadSafe;

public class NotThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String txt) {
        builder.append(txt);
    }

    public int length() {
        return builder.length();
    }
}
