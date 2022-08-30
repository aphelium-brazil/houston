package io.github.aphelium.modules.coin.useCases.createCrypto

import io.github.aphelium.modules.coin.dtos.CreateCryptoDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/crypto")
class CreateCryptoController(private val createCryptoUseCase: CreateCryptoUseCase) {
    @PostMapping
    fun createCrypto(@RequestBody createCryptoDTO: @Valid CreateCryptoDTO): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createCryptoUseCase.execute(createCryptoDTO))
    }
}