package io.github.aphelium.modules.brokers.repositories

import io.github.aphelium.modules.brokers.entities.BrokerCoins
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BrokerCoinsRepository : JpaRepository<BrokerCoins?, UUID?>