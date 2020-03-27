package com.company;

public class Param {
    String key;
    Object value;

    public Param(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "{ " + this.key + ", " + this.value + " }";
    }
}
