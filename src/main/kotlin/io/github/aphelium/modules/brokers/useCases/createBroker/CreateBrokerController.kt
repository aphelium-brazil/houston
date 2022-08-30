package io.github.aphelium.modules.brokers.useCases.createBroker

import io.github.aphelium.modules.brokers.dtos.CreateBrokerDTO
import io.github.aphelium.modules.brokers.exceptions.BrokerAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/broker")
class CreateBrokerController(private val createBrokerUseCase: CreateBrokerUseCase) {
    @PostMapping
    @Throws(BrokerAlreadyExistsException::class)
    fun createBroker(@RequestBody createBrokerDTO: @Valid CreateBrokerDTO?): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createBrokerUseCase.execute(createBrokerDTO))
    }
}