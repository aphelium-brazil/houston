package io.github.aphelium.modules.coin.entities

import java.io.Serial
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_CRYPTO")
class Crypto : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null

    @Column(nullable = false, unique = true, length = 50)
    val name: String? = null

    @Column(nullable = true)
    val description: String? = null

    @Column(nullable = false, unique = true)
    val code: String? = null

    @Column
    val isActive: Boolean? = null

    @Column(nullable = true)
    val logo: String? = null

    @Column(nullable = false)
    val firstHistoricalDate: String? = null

    @Column(nullable = true)
    val lastHistoricalDate: String? = null

    @Column(nullable = false)
    var createdAt: LocalDateTime? = null

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null

    companion object {
        @Serial
        private val serialVersionUID = -8080540494839892473L
    }
}