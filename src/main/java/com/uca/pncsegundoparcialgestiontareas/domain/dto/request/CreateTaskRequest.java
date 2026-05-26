package com.uca.pncsegundoparcialgestiontareas.domain.dto.request;

import com.uca.pncsegundoparcialgestiontareas.common.Priority;
import com.uca.pncsegundoparcialgestiontareas.common.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Date;

// Fields 'status' and 'active' are set values on creation, so there is no
// need to ask them in the request.

public record CreateTaskRequest(
        @NotBlank(message = "Title can't be empty")
        @UniqueElements(message = "Another task has the same title")
        String title,

        String description,

        @NotNull(message = "Priority is required")
        Priority priority,

        @NotNull(message = "Estimated hours is required")
        @Positive(message = "Estimated hours must be greater or equal to 1")
        Integer estimatedHours,

        @PositiveOrZero(message = "Estimated hours must be greater or equal to 0")
        Integer loggedHours,

        @NotNull(message = "Due date is required")
        Date dueDate,

        @NotBlank(message = "The task must be assigned to someone")
        String assignedTo
) {
}
