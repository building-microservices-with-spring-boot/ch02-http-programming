package com.example.model;

public class Result {
    private Integer result;
    private String type;

    public Result(Integer result, String type) {
        this.result = result;
        this.type = type;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
