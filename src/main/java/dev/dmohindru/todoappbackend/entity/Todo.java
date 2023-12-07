package dev.dmohindru.todoappbackend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Todo")
public class Todo {

    @Id
    private String _id;

    private String todoTitle;

    private String description;

    private Boolean done;

    private Boolean deleted;

    private String todoTitleId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
