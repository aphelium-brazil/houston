package io.github.aphelium.modules.coin.dtos

import javax.validation.constraints.NotBlank

class CreateCryptoDTO {
    val name: @NotBlank(message = "The name is mandatory") String? = null
    val description: @NotBlank(message = "The description is mandatory") String? = null
    val code: @NotBlank(message = "The code is mandatory") String? = null
    val isActive: Boolean? = null
    val logo: String? = null
    val firstHistoricalDate: @NotBlank(message = "The first historical date is mandatory") String? = null
    val lastHistoricalDate: String? = null
}