package dev.dmohindru.todoappbackend.entity.mongodb;

import lombok.Builder;
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
@Document("User")
@Builder
public class User {
    @Id
    private String _id;

    private UUID externalId;

    private String username;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @DocumentReference
    List<TodoTitle> todoTitleList;

    @Version
    private Integer version;
}
