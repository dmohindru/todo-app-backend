package dev.dmohindru.todoappbackend.entity.mongodb;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("User")
@Builder
public class User {
    @Id
    private String _id;

    private String username;

    private String name;

    // Read this blog for enabling @CreatedDate and @LastModifiedDate
    // https://bootify.io/mongodb/created-and-last-modified-date-in-spring-data-mongodb.html

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // reading from this blog
    // https://spring.io/blog/2021/11/29/spring-data-mongodb-relation-modelling
    @DocumentReference
    List<TodoTitle> todoTitleList;
}
