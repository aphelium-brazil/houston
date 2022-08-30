package io.github.aphelium.modules.coin.useCases.createCrypto;

import io.github.aphelium.modules.coin.dtos.CreateCryptoDTO;
import io.github.aphelium.modules.coin.entities.Crypto;
import io.github.aphelium.modules.coin.exceptions.CryptoAlredyExistsException;
import io.github.aphelium.modules.coin.repositories.CryptoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CreateCryptoUseCase {

    final CryptoRepository cryptoRepository;

    public CreateCryptoUseCase(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @Transactional
    public Crypto execute(CreateCryptoDTO dto) throws CryptoAlredyExistsException {

        Crypto crypto = new Crypto();

        //Check if the crypto already exists
        if(cryptoRepository.findByName(dto.getName()).isPresent()) {
            throw new CryptoAlredyExistsException();
        }

        BeanUtils.copyProperties(dto, crypto);

        crypto.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        crypto.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        cryptoRepository.save(crypto);

        return crypto;

    }

}
