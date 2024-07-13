package com.erenn.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.ID")
    @JsonBackReference
    private User user;

    private String text;

    private boolean isDone;

    @CreatedDate
    private Instant createdOn;

    private Instant dueDate;

    public Task(User user, String text, boolean isDone, Instant dueDate) {
        this.user = user;
        this.text = text;
        this.isDone = isDone;
        this.dueDate = dueDate;
    }

    private void setID(UUID ID) {
        this.ID = ID;
    }

}
