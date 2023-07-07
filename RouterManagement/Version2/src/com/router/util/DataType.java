package com.router.util;

public enum DataType {
    MANAGEMENT(1), USER(2);

    private int priority;
    DataType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

}
