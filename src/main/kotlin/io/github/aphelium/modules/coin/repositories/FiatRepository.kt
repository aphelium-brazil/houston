package io.github.aphelium.modules.coin.repositories

import io.github.aphelium.modules.coin.entities.Fiat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FiatRepository : JpaRepository<Fiat?, UUID?> {
    fun findByName(name: String?): Optional<Fiat?>
}