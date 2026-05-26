package com.uca.pncsegundoparcialgestiontareas.domain.entities;

import com.uca.pncsegundoparcialgestiontareas.common.Priority;
import com.uca.pncsegundoparcialgestiontareas.common.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "logged_hours")
    private Integer loggedHours;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "is_active")
    private Boolean active;
}
