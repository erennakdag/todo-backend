package com.erenn.todoapp.TodoList;

import jakarta.persistence.*;
import com.erenn.todoapp.User.User;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "list")
public class TodoListElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.ID")
    private User user;

    private String text;

    private boolean isDone;

    @CreatedDate
    private Instant createdOn;

    public TodoListElement() {}

    public TodoListElement(User user, String text, boolean isDone, Instant createdOn) {
        this.user = user;
        this.text = text;
        this.isDone = isDone;
        this.createdOn = createdOn;
    }

    public TodoListElement(Long ID, User user, String text, boolean isDone, Instant createdOn) {
        this.ID = ID;
        this.user = user;
        this.text = text;
        this.isDone = isDone;
        this.createdOn = createdOn;
    }

    public User getUser() {
        return user;
    }

    public Long getID() {
        return ID;
    }

    private void setID(Long ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
}
