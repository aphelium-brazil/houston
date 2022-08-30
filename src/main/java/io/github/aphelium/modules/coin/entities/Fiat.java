package io.github.aphelium.modules.coin.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_FIAT")
public class Fiat implements Serializable {

    @Serial
    private static final long serialVersionUID = -8080540494839892473L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private Boolean isActive;

    @Column(nullable = false)
    private UUID country;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
