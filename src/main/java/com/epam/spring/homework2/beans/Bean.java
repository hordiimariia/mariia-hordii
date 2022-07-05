package com.epam.spring.homework2.beans;

public abstract class Bean {
    private String name;
    private int value;

    public Bean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Bean() {
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " name = " + name + ", value = " + value;
    }

    public void validate() {
        if (name == null) {
            name = "default";
        }

        if (value <= 0) {
            value = 1;
        }
    }
}
