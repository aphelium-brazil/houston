package io.github.aphelium.modules.coin.repositories

import io.github.aphelium.modules.coin.entities.Crypto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CryptoRepository : JpaRepository<Crypto?, UUID?> {
    fun findByName(name: String?): Optional<Crypto?>
}