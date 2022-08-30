package io.github.aphelium.modules.brokers.entities;

import io.github.aphelium.modules.coin.entities.Coin;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_BROKER_COINS")
public class BrokerCoins implements Serializable {

    @Serial
    private static final long serialVersionUID = -8080540494839892473L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID broker;

    @Column(nullable = false)
    private UUID coin;

}
