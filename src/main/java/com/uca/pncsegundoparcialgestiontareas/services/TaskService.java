package com.uca.pncsegundoparcialgestiontareas.services;

import com.uca.pncsegundoparcialgestiontareas.domain.dto.request.CreateTaskRequest;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.request.UpdateTaskRequest;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.response.TaskResponse;
import com.uca.pncsegundoparcialgestiontareas.domain.entities.Task;
import com.uca.pncsegundoparcialgestiontareas.exceptions.ResourceNotFoundException;
import com.uca.pncsegundoparcialgestiontareas.mappers.TaskMapper;
import com.uca.pncsegundoparcialgestiontareas.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void createTask(CreateTaskRequest task) {
        taskRepository.save(TaskMapper.toEntityCreate(task));
    }

    public TaskResponse findTaskById(UUID id) {
        return TaskMapper.toDTO(
            taskRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("The task could not be found")
            )
        );
    }

    public List<TaskResponse> findAllTasks() {
        return TaskMapper.toDTOList(
                taskRepository.findAll()
        );
    }

    public void updateTask(UUID id, UpdateTaskRequest task){
        if (taskRepository.existsById(id)) {
            Task entity = TaskMapper.toUpdateTask(id, task);
            taskRepository.save(entity);
        }
    }

    public void deleteTask(UUID id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }
}
