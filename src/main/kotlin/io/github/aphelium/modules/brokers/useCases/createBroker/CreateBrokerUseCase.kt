package io.github.aphelium.modules.brokers.useCases.createBroker

import io.github.aphelium.modules.brokers.dtos.CreateBrokerDTO
import io.github.aphelium.modules.brokers.entities.Broker
import io.github.aphelium.modules.brokers.exceptions.BrokerAlreadyExistsException
import io.github.aphelium.modules.brokers.repositories.BrokerRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import javax.transaction.Transactional

@Service
class CreateBrokerUseCase(val brokerRepository: BrokerRepository) {
    @Transactional
    @Throws(BrokerAlreadyExistsException::class)
    fun execute(dto: CreateBrokerDTO?): Broker {
        val broker = Broker()

        // Check if the broker already exists
        if (brokerRepository.findByName(dto!!.name).isPresent) {
            throw BrokerAlreadyExistsException()
        }
        BeanUtils.copyProperties(dto, broker)
        broker.createdAt = LocalDateTime.now(ZoneId.of("UTC"))
        broker.updatedAt = LocalDateTime.now(ZoneId.of("UTC"))
        brokerRepository.save(broker)
        return broker
    }
}