package io.github.aphelium.modules.brokers.useCases.addCoinToBroker

import io.github.aphelium.modules.brokers.dtos.AddCoinToBrokerDTO
import io.github.aphelium.modules.coin.enums.CoinType
import io.github.aphelium.modules.coin.exceptions.CoinNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/broker/")
class AddCoinToBrokerController(private val addCoinToBrokerUseCase: AddCoinToBrokerUseCase) {
    @PostMapping("/{brokerId}")
    @Throws(CoinNotFoundException::class)
    fun addCoinToBroker(
            @PathVariable("brokerId") brokerId: String?,
            @RequestParam("CoinType") type: CoinType,
            @RequestBody addCoinToBrokerDTO: @Valid AddCoinToBrokerDTO?): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(addCoinToBrokerUseCase.executeWithLock(brokerId, type, addCoinToBrokerDTO))
    }
}