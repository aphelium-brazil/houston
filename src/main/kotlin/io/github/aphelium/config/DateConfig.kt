package io.github.aphelium.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.time.format.DateTimeFormatter

@Configuration
class DateConfig {
    @Bean
    @Primary
    fun objectMapper(): ObjectMapper {
        val module = JavaTimeModule()
        module.addSerializer(LOCAL_DATE_TIME_SERIALIZER)
        return ObjectMapper().registerModule(module)
    }

    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val LOCAL_DATE_TIME_SERIALIZER = LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN))
    }
}