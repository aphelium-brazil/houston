package io.github.aphelium.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Category {

    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
