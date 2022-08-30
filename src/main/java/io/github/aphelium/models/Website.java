package io.github.aphelium.models;
import java.time.LocalDateTime;
import java.util.UUID;

public class Website {

    private UUID id;
    private String name;
    private String description;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
