package site.memoria.global.response;

import lombok.Getter;
import site.memoria.global.exception.ErrorCode;

@Getter
public class ApiResponse<T> {

    private final boolean success;
    private final String errorCode;
    private final String message;
    private final T data;

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(
            true,
            null,
            "API가 성공적으로 수행되었습니다.",
            null
        );
    }

    public static <T> ApiResponse<T> success(final T data) {
        return new ApiResponse<>(
            true,
            null,
            "API가 성공적으로 수행되었습니다.",
            data
        );
    }

    public static ApiResponse<Void> fail(final ErrorCode errorCode) {
        return new ApiResponse<>(
            false,
            errorCode.getValue(),
            errorCode.getMessage(),
            null
        );
    }

    private ApiResponse(
        final boolean success,
        final String errorCode,
        final String message,
        final T data
    ) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }
}
