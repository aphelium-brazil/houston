package io.github.aphelium.modules.coin.useCases.createFiat

import io.github.aphelium.modules.coin.dtos.CreateFiatDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/fiat")
class CreateFiatController(private val createFiatUseCase: CreateFiatUseCase) {
    @PostMapping
    fun createFiat(@RequestBody createFiatDTO: @Valid CreateFiatDTO): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createFiatUseCase.execute(createFiatDTO))
    }
}