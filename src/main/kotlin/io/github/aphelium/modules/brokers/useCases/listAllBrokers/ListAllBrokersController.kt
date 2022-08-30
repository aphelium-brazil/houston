package io.github.aphelium.modules.brokers.useCases.listAllBrokers


import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/v1/broker")
class ListAllBrokersController(private val listAllBrokersUseCase: ListAllBrokersUseCase) {
    @GetMapping
    fun listAllBrokers(@PageableDefault(page = 0, size = 10, sort = ["id"], direction = Sort.Direction.ASC) pageable: Pageable): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.OK).body(listAllBrokersUseCase.execute(pageable))
    }
}