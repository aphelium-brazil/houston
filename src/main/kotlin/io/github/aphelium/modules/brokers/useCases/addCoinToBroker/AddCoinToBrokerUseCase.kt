package io.github.aphelium.modules.brokers.useCases.addCoinToBroker

import io.github.aphelium.modules.brokers.dtos.AddCoinToBrokerDTO
import io.github.aphelium.modules.brokers.entities.BrokerCoins
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException
import io.github.aphelium.modules.brokers.repositories.BrokerCoinsRepository
import io.github.aphelium.modules.brokers.repositories.BrokerRepository
import io.github.aphelium.modules.coin.enums.CoinType
import io.github.aphelium.modules.coin.exceptions.CoinNotFoundException
import io.github.aphelium.modules.coin.repositories.CryptoRepository
import io.github.aphelium.modules.coin.repositories.FiatRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.LockModeType

@Service
class AddCoinToBrokerUseCase(val brokerRepository: BrokerRepository,
                             val cryptoRepository: CryptoRepository,
                             val fiatRepository: FiatRepository,
                             val brokerCoinsRepository: BrokerCoinsRepository) {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun executeWithLock(brokerId: String?, type: CoinType, dto: AddCoinToBrokerDTO?): BrokerCoins {
        val brokerCoins = BrokerCoins()
        val broker = brokerRepository.findById(UUID.fromString(brokerId)).orElseThrow { BrokerNotFoundException() }!!
        if (CoinType.CRYPTO == type) {
            val crypto = cryptoRepository.findById(UUID.fromString(dto!!.coin)).orElseThrow { CoinNotFoundException() }!!
            brokerCoins.broker = broker.id
            brokerCoins.coin = crypto.id

            //Verificar se já existe
            brokerCoinsRepository.save(brokerCoins)
        }
        if (CoinType.FIAT == type) {
            val fiat = fiatRepository.findById(UUID.fromString(dto!!.coin)).orElseThrow { CoinNotFoundException() }!!
            brokerCoins.broker = broker.id
            brokerCoins.coin = fiat.id

            //Verificar se já existe
            brokerCoinsRepository.save(brokerCoins)
        }
        return brokerCoins
    }
}