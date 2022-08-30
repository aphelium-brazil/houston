package io.github.aphelium.modules.coin.useCases.createCrypto;

import io.github.aphelium.modules.coin.dtos.CreateCryptoDTO;
import io.github.aphelium.modules.coin.entities.Crypto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CoinsController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/crypto")
public class CreateCryptoController {

    private final CreateCryptoUseCase createCryptoUseCase;

    public CreateCryptoController(CreateCryptoUseCase createCryptoUseCase) {
        this.createCryptoUseCase = createCryptoUseCase;
    }

    @ApiOperation(value = "Create a new crypto", response = Crypto.class)
    @PostMapping
    public ResponseEntity<Object> createCrypto(@RequestBody @Valid CreateCryptoDTO createCryptoDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(createCryptoUseCase.execute(createCryptoDTO));

    }

}
