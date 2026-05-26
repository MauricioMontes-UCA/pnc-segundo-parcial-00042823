package com.uca.pncsegundoparcialgestiontareas.controllers;

import com.uca.pncsegundoparcialgestiontareas.domain.dto.request.CreateTaskRequest;
import com.uca.pncsegundoparcialgestiontareas.domain.dto.response.GeneralResponse;
import com.uca.pncsegundoparcialgestiontareas.services.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<GeneralResponse> findAll() {
        return ResponseEntity.ok(
                GeneralResponse.builder()
                .data(taskService.findAllTasks())
                .status(HttpStatus.OK.value())
                .message("Tasks found")
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> findById(@PathVariable UUID id){
        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(taskService.findTaskById(id))
                        .status(HttpStatus.OK.value())
                        .message("Task found")
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        taskService.createTask(request);
        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(request)
                        .status(HttpStatus.CREATED.value())
                        .message("Task created")
                        .build()
        );
    }


}
