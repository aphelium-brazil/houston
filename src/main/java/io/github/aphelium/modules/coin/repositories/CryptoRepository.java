package io.github.aphelium.modules.coin.repositories;

import io.github.aphelium.modules.coin.entities.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, UUID> {

    Optional<Crypto> findByName(String name);

}
