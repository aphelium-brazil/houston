package io.github.aphelium.modules.brokers.entities

import java.io.Serial
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_BROKERS")
class Broker : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null

    @Column(nullable = false, unique = true, length = 50)
    var name: String? = null

    @Column(nullable = true)
    var description: String? = null

    @Column(nullable = false)
    var slug: String? = null

    @Column(nullable = true)
    var logo: String? = null

    @Column(nullable = true)
    var dateLaunched: LocalDateTime? = null

    @Column(nullable = false)
    var createdAt: LocalDateTime? = null

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null

    companion object {
        @Serial
        private val serialVersionUID = -8080540494839892473L
    }
}