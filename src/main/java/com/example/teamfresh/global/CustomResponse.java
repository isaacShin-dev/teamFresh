package com.example.teamfresh.global;

import org.springframework.http.HttpStatus;

public class CustomResponse<T> {

    public enum StatusCode {
        SUCCESS(200, "Success"),
        ERROR(500, "Error"),
        FAIL(400, "Fail");

        private final int code;
        private final String message;

        StatusCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    private int status;
    private String message;
    private T data;

    public CustomResponse(StatusCode statusCode, T data) {
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public static <T> CustomResponse<T> success(T data) {
        return new CustomResponse<>(StatusCode.SUCCESS, data);
    }

    public static <T> CustomResponse<T> error(StatusCode statusCode, String message) {
        return new CustomResponse<>(statusCode, null);
    }

    // Getters and setters

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
