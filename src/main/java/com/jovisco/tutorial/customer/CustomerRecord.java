package com.jovisco.tutorial.customer;

public record CustomerRecord(String name) {

    @Override
    public String toString() {
        return name;
    }
}
