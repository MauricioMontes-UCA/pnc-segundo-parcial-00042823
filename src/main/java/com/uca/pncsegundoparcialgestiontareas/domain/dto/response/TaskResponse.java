package com.uca.pncsegundoparcialgestiontareas.domain.dto.response;


import com.uca.pncsegundoparcialgestiontareas.common.Priority;
import com.uca.pncsegundoparcialgestiontareas.common.Status;
import lombok.Builder;

import java.sql.Date;
import java.util.UUID;

@Builder
public record TaskResponse(
        UUID id,
        String title,
        String description,
        Status status,
        Priority priority,
        Integer estimatedHours,
        Integer loggedHours,
        Date dueDate,
        String assignedTo,
        Boolean active
) {
}
