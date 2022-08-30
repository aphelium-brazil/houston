package io.github.aphelium.modules.brokers.useCases.listAllBrokers

import io.github.aphelium.modules.brokers.entities.Broker
import io.github.aphelium.modules.brokers.repositories.BrokerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ListAllBrokersUseCase(val brokerRepository: BrokerRepository) {
    fun execute(pageable: Pageable): Page<Broker?> {
        return brokerRepository.findAll(pageable)
    }
}