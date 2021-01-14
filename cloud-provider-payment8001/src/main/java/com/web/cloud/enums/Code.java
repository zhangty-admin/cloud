package com.web.cloud.enums;

public enum Code {
    SUCCESS(200), ERROR(500), WARN(301);

    private Integer value;

    Code(Integer value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
