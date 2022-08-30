package io.github.aphelium.modules.coin.entities;

import io.github.aphelium.modules.brokers.entities.Broker;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_CRYPTO")
public class Crypto implements Serializable {

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

    @Column(nullable = true)
    private String logo;

    @Column(nullable = false)
    private String firstHistoricalDate;

    @Column(nullable = true)
    private String lastHistoricalDate;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
