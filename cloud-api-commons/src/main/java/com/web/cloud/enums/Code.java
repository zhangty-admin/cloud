package com.web.cloud.enums;

public enum Code {
    SUCCESS(200),ERROR(500),WARN(301);

    private Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer value() {
        return this.code;
    }

}
