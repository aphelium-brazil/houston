package io.github.aphelium.modules.coin.useCases.createFiat;

import io.github.aphelium.modules.coin.dtos.CreateFiatDTO;
import io.github.aphelium.modules.coin.entities.Fiat;
import io.github.aphelium.modules.coin.exceptions.FiatAlredyExistsException;
import io.github.aphelium.modules.coin.repositories.FiatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class CreateFiatUseCase {

    final FiatRepository fiatRepository;

    public CreateFiatUseCase(FiatRepository fiatRepository) {
        this.fiatRepository = fiatRepository;
    }

    public Fiat execute(CreateFiatDTO dto) {

        Fiat fiat = new Fiat();

        //Check if the fiat already exists
        if(fiatRepository.findByName(dto.getName()).isPresent()) {
            throw new FiatAlredyExistsException();
        }

        //Check if the Country exists


        BeanUtils.copyProperties(dto, fiat);

        fiat.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        fiat.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        fiat.setCountry(UUID.fromString(dto.getCountry()));

        fiatRepository.save(fiat);

        return fiat;

    }

}
