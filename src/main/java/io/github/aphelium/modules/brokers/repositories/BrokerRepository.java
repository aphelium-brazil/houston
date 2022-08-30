package io.github.aphelium.modules.brokers.repositories;


import io.github.aphelium.modules.brokers.entities.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, UUID> {

    Optional<Broker> findByName(String name);

}
