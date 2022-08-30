package io.github.aphelium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoustonApplication
    fun main(args: Array<String>) {
        runApplication<HoustonApplication>(*args)
    }
