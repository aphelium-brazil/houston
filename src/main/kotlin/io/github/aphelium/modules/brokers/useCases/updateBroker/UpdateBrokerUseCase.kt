package io.github.aphelium.modules.brokers.useCases.updateBroker

import io.github.aphelium.modules.brokers.dtos.UpdateBrokerDTO
import io.github.aphelium.modules.brokers.entities.Broker
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException
import io.github.aphelium.modules.brokers.repositories.BrokerRepository
import org.springframework.beans.BeanUtils
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.persistence.LockModeType

@Service
class UpdateBrokerUseCase(val brokerRepository: BrokerRepository) {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun executeWithLock(id: UUID, dto: UpdateBrokerDTO): Broker {
        val broker = brokerRepository.findById(id).orElseThrow { BrokerNotFoundException() }!!
        BeanUtils.copyProperties(dto, broker)
        broker.updatedAt = LocalDateTime.now(ZoneId.of("UTC"))
        brokerRepository.save(broker)
        return broker
    }
}