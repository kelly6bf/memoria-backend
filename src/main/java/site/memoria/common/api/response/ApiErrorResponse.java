package site.memoria.common.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "에러 응답")
public record ApiErrorResponse(@Schema(description = "에러 메시지", example = "잘못된 요청 입니다.") String message) {
}
