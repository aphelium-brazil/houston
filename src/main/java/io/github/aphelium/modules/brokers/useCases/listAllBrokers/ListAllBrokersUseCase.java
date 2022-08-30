package io.github.aphelium.modules.brokers.useCases.listAllBrokers;

import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.repositories.BrokerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllBrokersUseCase {

    final BrokerRepository brokerRepository;

    public ListAllBrokersUseCase(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }

    public Page<Broker> execute(Pageable pageable) {
        return brokerRepository.findAll(pageable);
    }


}
