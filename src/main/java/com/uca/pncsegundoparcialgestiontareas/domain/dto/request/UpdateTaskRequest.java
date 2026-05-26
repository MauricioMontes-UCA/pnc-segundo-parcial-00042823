package com.uca.pncsegundoparcialgestiontareas.domain.dto.request;

import com.uca.pncsegundoparcialgestiontareas.common.Priority;
import com.uca.pncsegundoparcialgestiontareas.common.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Date;

// As far as I understand, and update doesn't require too many
// validations (such as not null)

public record UpdateTaskRequest(
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
