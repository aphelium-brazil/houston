package io.github.aphelium.modules.coin.useCases.createCrypto

import io.github.aphelium.modules.coin.dtos.CreateCryptoDTO
import io.github.aphelium.modules.coin.entities.Crypto
import io.github.aphelium.modules.coin.exceptions.CryptoAlredyExistsException
import io.github.aphelium.modules.coin.repositories.CryptoRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import javax.transaction.Transactional

@Service
class CreateCryptoUseCase(val cryptoRepository: CryptoRepository) {
    @Transactional
    @Throws(CryptoAlredyExistsException::class)
    fun execute(dto: CreateCryptoDTO): Crypto {
        val crypto = Crypto()

        //Check if the crypto already exists
        if (cryptoRepository.findByName(dto.name).isPresent) {
            throw CryptoAlredyExistsException()
        }
        BeanUtils.copyProperties(dto, crypto)
        crypto.createdAt = LocalDateTime.now(ZoneId.of("UTC"))
        crypto.updatedAt = LocalDateTime.now(ZoneId.of("UTC"))
        cryptoRepository.save(crypto)
        return crypto
    }
}