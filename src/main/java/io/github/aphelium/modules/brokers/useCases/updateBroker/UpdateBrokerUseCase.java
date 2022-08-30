package io.github.aphelium.modules.brokers.useCases.updateBroker;


import io.github.aphelium.modules.brokers.dtos.UpdateBrokerDTO;
import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException;
import io.github.aphelium.modules.brokers.repositories.BrokerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class UpdateBrokerUseCase {

    final BrokerRepository brokerRepository;

    public UpdateBrokerUseCase(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Broker executeWithLock(UUID id, UpdateBrokerDTO dto) {

        Broker broker = brokerRepository.findById(id).orElseThrow(() -> new BrokerNotFoundException());

        BeanUtils.copyProperties(dto, broker);

        broker.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        brokerRepository.save(broker);

        return broker;

    }

}
