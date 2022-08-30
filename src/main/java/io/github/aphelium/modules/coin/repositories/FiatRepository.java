package io.github.aphelium.modules.coin.repositories;

import io.github.aphelium.modules.coin.entities.Fiat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FiatRepository extends JpaRepository<Fiat, UUID> {

    Optional<Fiat> findByName(String name);

}
