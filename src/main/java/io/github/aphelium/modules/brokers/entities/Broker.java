package io.github.aphelium.modules.brokers.entities;

import io.github.aphelium.modules.coin.entities.Crypto;
import io.github.aphelium.modules.coin.entities.Fiat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_BROKERS")
public class Broker implements Serializable {

    @Serial
    private static final long serialVersionUID = -8080540494839892473L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = true)
    private String logo;

    @Column(nullable = true)
    private LocalDateTime dateLaunched;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
