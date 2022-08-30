package io.github.aphelium.modules.brokers.useCases.addCoinToBroker;


import io.github.aphelium.modules.brokers.dtos.AddCoinToBrokerDTO;
import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.entities.BrokerCoins;
import io.github.aphelium.modules.brokers.exceptions.BrokerNotFoundException;
import io.github.aphelium.modules.brokers.repositories.BrokerCoinsRepository;
import io.github.aphelium.modules.brokers.repositories.BrokerRepository;
import io.github.aphelium.modules.coin.entities.Crypto;
import io.github.aphelium.modules.coin.entities.Fiat;
import io.github.aphelium.modules.coin.enums.CoinType;
import io.github.aphelium.modules.coin.exceptions.CoinNotFoundException;
import io.github.aphelium.modules.coin.repositories.CryptoRepository;
import io.github.aphelium.modules.coin.repositories.FiatRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.util.UUID;

@Service
public class AddCoinToBrokerUseCase {

    final BrokerRepository brokerRepository;

    final CryptoRepository cryptoRepository;

    final FiatRepository fiatRepository;

    final BrokerCoinsRepository brokerCoinsRepository;

    public AddCoinToBrokerUseCase(BrokerRepository brokerRepository,
                                    CryptoRepository cryptoRepository,
                                    FiatRepository fiatRepository,
                                    BrokerCoinsRepository brokerCoinsRepository) {
        this.brokerRepository = brokerRepository;
        this.cryptoRepository = cryptoRepository;
        this.fiatRepository = fiatRepository;
        this.brokerCoinsRepository = brokerCoinsRepository;
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public BrokerCoins executeWithLock(String brokerId, CoinType type,AddCoinToBrokerDTO dto) {

        BrokerCoins brokerCoins = new BrokerCoins();

        Broker broker = brokerRepository.findById(UUID.fromString(brokerId)).orElseThrow(() -> new BrokerNotFoundException());

        if(CoinType.CRYPTO == type) {

            Crypto crypto = cryptoRepository.findById(UUID.fromString(dto.coin)).orElseThrow(() -> new CoinNotFoundException());

            brokerCoins.setBroker(broker.getId());
            brokerCoins.setCoin(crypto.getId());

            //Verificar se já existe

            brokerCoinsRepository.save(brokerCoins);



        }

        if(CoinType.FIAT == type) {

            Fiat fiat = fiatRepository.findById(UUID.fromString(dto.coin)).orElseThrow(() -> new CoinNotFoundException());

            brokerCoins.setBroker(broker.getId());
            brokerCoins.setCoin(fiat.getId());

            //Verificar se já existe

            brokerCoinsRepository.save(brokerCoins);

        }

        return brokerCoins;
    }


}
