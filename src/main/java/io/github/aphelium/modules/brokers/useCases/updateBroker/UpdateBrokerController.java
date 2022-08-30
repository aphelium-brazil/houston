package io.github.aphelium.modules.brokers.useCases.updateBroker;


import io.github.aphelium.modules.brokers.dtos.UpdateBrokerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Api(value = "BrokersController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/broker")
public class UpdateBrokerController {

    private final UpdateBrokerUseCase updateBrokerUseCase;

    public UpdateBrokerController(UpdateBrokerUseCase updateBrokerUseCase) {
        this.updateBrokerUseCase = updateBrokerUseCase;
    }

    @ApiOperation(value = "Update a broker")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBroker(@PathVariable("id") UUID id, @RequestBody @Valid UpdateBrokerDTO updateBrokerDTO){

        return ResponseEntity.status(HttpStatus.OK).body(updateBrokerUseCase.executeWithLock(id, updateBrokerDTO));

    }


}
