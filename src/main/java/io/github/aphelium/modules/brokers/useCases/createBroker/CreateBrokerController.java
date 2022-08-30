package io.github.aphelium.modules.brokers.useCases.createBroker;

import io.github.aphelium.modules.brokers.dtos.CreateBrokerDTO;
import io.github.aphelium.modules.brokers.entities.Broker;
import io.github.aphelium.modules.brokers.exceptions.BrokerAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "BrokersController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/broker")
public class CreateBrokerController {

    private final CreateBrokerUseCase createBrokerUseCase;

    public CreateBrokerController(CreateBrokerUseCase createBrokerUseCase) {
        this.createBrokerUseCase = createBrokerUseCase;
    }

    @ApiOperation(value = "Create a new broker", response = Broker.class)
    @ApiResponse(code = 302, message = "Broker already exists")
    @PostMapping
    public ResponseEntity<Object> createBroker(@RequestBody @Valid CreateBrokerDTO createBrokerDTO) throws BrokerAlreadyExistsException {

        return ResponseEntity.status(HttpStatus.CREATED).body(createBrokerUseCase.execute(createBrokerDTO));

    }

}
