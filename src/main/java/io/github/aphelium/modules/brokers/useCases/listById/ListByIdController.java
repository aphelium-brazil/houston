package io.github.aphelium.modules.brokers.useCases.listById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(value = "BrokersController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/broker")
public class ListByIdController {

    private final ListByIdUseCase listByIdUseCase;

    public ListByIdController(ListByIdUseCase listByIdUseCase) {
        this.listByIdUseCase = listByIdUseCase;
    }

    @ApiOperation(value = "List a broker by id")
    @GetMapping("/{id}")
    public ResponseEntity<Object> listById(@PathVariable("id") UUID id){

        return ResponseEntity.status(HttpStatus.OK).body(listByIdUseCase.execute(id).get());

    }

}
