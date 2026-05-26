package com.uca.pncsegundoparcialgestiontareas.domain.dto.response;

public record APIErrorResponse(
        Object data,
        Integer status,
        String message
) {
}
