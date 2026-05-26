package com.uca.pncsegundoparcialgestiontareas.domain.dto.response;

import lombok.Builder;

@Builder
public record GeneralResponse(
        Object data,
        Integer status,
        String message
) {
}
