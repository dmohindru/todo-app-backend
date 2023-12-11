package dev.dmohindru.todoappbackend.entity.mongodb;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document("TodoTitle")
public class TodoTitle {
    @Id
    private String _id;

    private UUID externalId;

    private String titleName;

    private String description;

    private Boolean deleted;

    @DocumentReference(lazy = true)
    private User user;

    @DocumentReference
    private List<Todo> todoList;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Version
    private Integer version;
}
