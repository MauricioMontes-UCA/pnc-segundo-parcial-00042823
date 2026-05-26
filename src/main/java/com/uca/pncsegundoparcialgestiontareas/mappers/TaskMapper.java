package com.uca.pncsegundoparcialgestiontareas.mappers;

import com.uca.pncsegundoparcialgestiontareas.common.Status;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.request.CreateTaskRequest;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.request.UpdateTaskRequest;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.response.TaskResponse;
import com.uca.pncsegundoparcialgestiontareas.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public class TaskMapper {
    public static Task toEntityCreate(CreateTaskRequest request){
        return Task.builder()
                .title(request.title())
                .description(request.description())
                .status(Status.PENDING)
                .priority(request.priority())
                .estimatedHours(request.estimatedHours())
                .loggedHours(request.loggedHours())
                .dueDate(request.dueDate())
                .assignedTo(request.assignedTo())
                .active(true)
                .build();
    }

    public static Task toUpdateTask(UUID id, UpdateTaskRequest request){
        return Task.builder()
                .id(id)
                .title(request.title())
                .description(request.description())
                .status(request.status())
                .priority(request.priority())
                .estimatedHours(request.estimatedHours())
                .loggedHours(request.loggedHours())
                .dueDate(request.dueDate())
                .assignedTo(request.assignedTo())
                .active(request.active())
                .build();
    }

    public static TaskResponse toDTO(Task entity) {
        return TaskResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .priority(entity.getPriority())
                .estimatedHours(entity.getEstimatedHours())
                .loggedHours(entity.getLoggedHours())
                .dueDate(entity.getDueDate())
                .assignedTo(entity.getAssignedTo())
                .active(entity.getActive())
                .build();
    }

    public static List<TaskResponse> toDTOList(List<Task> entities) {
        return entities.stream().map(
                TaskMapper::toDTO
        ).toList();
    }
}
