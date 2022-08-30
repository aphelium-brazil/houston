package io.github.aphelium.modules.brokers.useCases.listById


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/broker")
class ListByIdController(private val listByIdUseCase: ListByIdUseCase) {
    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK).body(listByIdUseCase.execute(id))
    }
}