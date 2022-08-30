package io.github.aphelium.modules.brokers.repositories

import io.github.aphelium.modules.brokers.entities.Broker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BrokerRepository : JpaRepository<Broker?, UUID?> {
    fun findByName(name: String?): Optional<Broker?>
}