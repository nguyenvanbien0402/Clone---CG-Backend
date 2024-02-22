package com.backend.response;

import com.backend.enums.ApiStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {

    @Builder.Default
    private String code = "ASC200";
    @Builder.Default
    private String message = "Success";
    private T data;
    private Long responseTime = System.currentTimeMillis();



    public BaseResponse(T data) {
        responseTime = System.currentTimeMillis();
        this.code = ApiStatus.SUCCESS.getCode();
        this.message = ApiStatus.SUCCESS.getMessage();
        this.data = data;
    }
    public BaseResponse(ApiStatus apiStatus) {
        responseTime = System.currentTimeMillis();
        this.code = apiStatus.getCode();
        this.message = apiStatus.getMessage();
    }
}
