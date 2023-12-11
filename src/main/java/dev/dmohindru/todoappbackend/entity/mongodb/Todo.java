package dev.dmohindru.todoappbackend.entity.mongodb;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("Todo")
public class Todo {
    @Id
    private String _id;

    private UUID externalId;

    private String todoTitle;

    private String description;

    private Boolean done;

    private Boolean deleted;


    @DocumentReference(lazy = true)
    private TodoTitle todoTitleParent;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Version
    private Integer version;
}
