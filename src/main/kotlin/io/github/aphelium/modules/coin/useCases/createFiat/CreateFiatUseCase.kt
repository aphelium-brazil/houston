package io.github.aphelium.modules.coin.useCases.createFiat

import io.github.aphelium.modules.coin.dtos.CreateFiatDTO
import io.github.aphelium.modules.coin.entities.Fiat
import io.github.aphelium.modules.coin.exceptions.FiatAlredyExistsException
import io.github.aphelium.modules.coin.repositories.FiatRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Service
class CreateFiatUseCase(val fiatRepository: FiatRepository) {
    fun execute(dto: CreateFiatDTO): Fiat {
        val fiat = Fiat()

        //Check if the fiat already exists
        if (fiatRepository.findByName(dto.name).isPresent) {
            throw FiatAlredyExistsException()
        }

        //Check if the Country exists
        BeanUtils.copyProperties(dto, fiat)
        fiat.createdAt = LocalDateTime.now(ZoneId.of("UTC"))
        fiat.updatedAt = LocalDateTime.now(ZoneId.of("UTC"))
        fiat.country = UUID.fromString(dto.country)
        fiatRepository.save(fiat)
        return fiat
    }
}