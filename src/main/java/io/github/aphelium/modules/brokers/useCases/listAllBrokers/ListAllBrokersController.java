package io.github.aphelium.modules.brokers.useCases.listAllBrokers;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "BrokersController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/broker")
public class ListAllBrokersController {

    private final ListAllBrokersUseCase listAllBrokersUseCase;

    public ListAllBrokersController(ListAllBrokersUseCase listAllBrokersUseCase) {
        this.listAllBrokersUseCase = listAllBrokersUseCase;
    }

    @GetMapping
    public ResponseEntity<Object> listAllBrokers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(listAllBrokersUseCase.execute(pageable));
    }

}
