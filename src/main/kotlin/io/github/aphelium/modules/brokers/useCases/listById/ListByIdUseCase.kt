package io.github.aphelium.modules.brokers.useCases.listById

import io.github.aphelium.modules.brokers.entities.Broker
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException
import io.github.aphelium.modules.brokers.repositories.BrokerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ListByIdUseCase(val brokerRepository: BrokerRepository) {
    fun execute(id: UUID): Broker {
        return brokerRepository.findById(id).orElseThrow { BrokerNotFoundException() }!!
    }
}