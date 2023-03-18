package com.trip.want.common.responseBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class WantResponse<T> {

    private HttpStatus resultCode;
    private T result;

    public static WantResponse<Void> success() {
        return new WantResponse<>(HttpStatus.OK, null);
    }

    public static <T> WantResponse<T> success(T result) {
        return new WantResponse<>(HttpStatus.OK, result);
    }
}
