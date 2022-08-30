package io.github.aphelium.modules.brokers.entities

import java.io.Serial
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_BROKER_COINS")
class BrokerCoins : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID? = null

    @Column(nullable = false)
    var broker: UUID? = null

    @Column(nullable = false)
    var coin: UUID? = null

    companion object {
        @Serial
        private val serialVersionUID = -8080540494839892473L
    }
}