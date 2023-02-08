package com.tdd.junit.junittest.model.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String resultCode;
    private Object res;
}
