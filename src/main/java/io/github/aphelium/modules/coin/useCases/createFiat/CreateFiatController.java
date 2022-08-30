package io.github.aphelium.modules.coin.useCases.createFiat;

import io.github.aphelium.modules.coin.dtos.CreateFiatDTO;
import io.github.aphelium.modules.coin.entities.Fiat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CoinsController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/fiat")
public class CreateFiatController {

    private final CreateFiatUseCase createFiatUseCase;

    public CreateFiatController(CreateFiatUseCase createFiatUseCase) {
        this.createFiatUseCase = createFiatUseCase;
    }

    @ApiOperation(value = "Create a new fiat", response = Fiat.class)
    @PostMapping
    public ResponseEntity<Object> createFiat(@RequestBody @Valid CreateFiatDTO createFiatDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(createFiatUseCase.execute(createFiatDTO));

    }

}
