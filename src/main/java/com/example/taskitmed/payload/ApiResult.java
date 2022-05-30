package com.example.taskitmed.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * API DAN CLIENTL LARGA BORADIGAN HAR QANDAY SUCCESS VA ERROR RESPONSE LAR QAYTADIGAN CLASS
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
    private int responseCode = 0;
    private String message;
    private T data;
    private List<ErrorData> errors;


    //RESPONSE WITH BOOLEAN (SUCCESS OR FAIL)
    private ApiResult(int responseCode) {
        this.responseCode = responseCode;
    }


    //SUCCESS RESPONSE WITH DATA
    private ApiResult(T data, int responseCode) {
        this.data = data;
        this.responseCode = responseCode;
    }

    //SUCCESS RESPONSE WITH DATA AND MESSAGE
    public ApiResult(T data, int responseCode, String message) {
        this.data = data;
        this.responseCode = responseCode;
        this.message = message;
    }

    //SUCCESS RESPONSE WITH MESSAGE
    private ApiResult(String message) {
        this.message = message;
        this.responseCode = 0;
    }

    //ERROR RESPONSE WITH MESSAGE AND ERROR CODE
    private ApiResult(String errorMsg, Integer errorCode) {
        this.responseCode = 0;
        this.errors = Collections.singletonList(new ErrorData(errorMsg, errorCode));
    }


    //ERROR RESPONSE WITH ERROR DATA LIST
    private ApiResult(List<ErrorData> errors) {
        this.responseCode = 0;
        this.errors = errors;
    }


}
