package io.github.aphelium.modules.brokers.useCases.createBroker;


import io.github.aphelium.modules.brokers.dtos.CreateBrokerDTO;
import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.exceptions.BrokerAlreadyExistsException;
import io.github.aphelium.modules.brokers.repositories.BrokerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Service
public class CreateBrokerUseCase {

    final BrokerRepository brokerRepository;

    public CreateBrokerUseCase(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }

    @Transactional
    public Broker execute(CreateBrokerDTO dto) throws BrokerAlreadyExistsException {

        Broker broker = new Broker();

        // Check if the broker already exists
        if(brokerRepository.findByName(dto.getName()).isPresent()) {
            throw new BrokerAlreadyExistsException();
        }


        BeanUtils.copyProperties(dto, broker);

        broker.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        broker.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        brokerRepository.save(broker);

        return broker;

    }

}
