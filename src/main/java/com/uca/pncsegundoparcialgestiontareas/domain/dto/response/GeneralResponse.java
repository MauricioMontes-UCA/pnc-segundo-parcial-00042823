package com.uca.pncsegundoparcialgestiontareas.domain.dto.response;

public record GeneralResponse(
        Object data,
        Integer status,
        String message
) {
}
