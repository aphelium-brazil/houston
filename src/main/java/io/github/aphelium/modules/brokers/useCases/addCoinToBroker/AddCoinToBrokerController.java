package io.github.aphelium.modules.brokers.useCases.addCoinToBroker;

import io.github.aphelium.modules.brokers.dtos.AddCoinToBrokerDTO;
import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.coin.enums.CoinType;
import io.github.aphelium.modules.coin.exceptions.CoinNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Api(value = "BrokersController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/broker/")
public class AddCoinToBrokerController {

    private final AddCoinToBrokerUseCase addCoinToBrokerUseCase;

    public AddCoinToBrokerController(AddCoinToBrokerUseCase addCoinToBrokerUseCase) {
        this.addCoinToBrokerUseCase = addCoinToBrokerUseCase;
    }

    @ApiOperation(value = "Add a new coin to a broker", response = Broker.class)
    @PostMapping("/{brokerId}")
    public ResponseEntity<Object> addCoinToBroker(
            @PathVariable("brokerId") String brokerId,
            @RequestParam("CoinType") CoinType type,
            @RequestBody @Valid AddCoinToBrokerDTO addCoinToBrokerDTO) throws CoinNotFoundException {

        return ResponseEntity.status(HttpStatus.CREATED).body(addCoinToBrokerUseCase.executeWithLock(brokerId, type, addCoinToBrokerDTO));

    }

}
