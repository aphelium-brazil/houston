package io.github.aphelium.modules.brokers.useCases.listById;

import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.repositories.BrokerRepository;
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListByIdUseCase {

    final BrokerRepository brokerRepository;

    public ListByIdUseCase(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }

    public Optional<Broker> execute(UUID id) {

        Broker broker = brokerRepository.findById(id).orElseThrow(() -> new BrokerNotFoundException());

        return Optional.ofNullable(broker);

    }

}
