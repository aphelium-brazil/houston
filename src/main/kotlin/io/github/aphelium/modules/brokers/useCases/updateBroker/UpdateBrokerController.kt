package io.github.aphelium.modules.brokers.useCases.updateBroker

import io.github.aphelium.modules.brokers.dtos.UpdateBrokerDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/broker")
class UpdateBrokerController(private val updateBrokerUseCase: UpdateBrokerUseCase) {
    @PutMapping("/{id}")
    fun updateBroker(@PathVariable("id") id: UUID, @RequestBody updateBrokerDTO: @Valid UpdateBrokerDTO): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.OK).body(updateBrokerUseCase.executeWithLock(id, updateBrokerDTO))
    }
}