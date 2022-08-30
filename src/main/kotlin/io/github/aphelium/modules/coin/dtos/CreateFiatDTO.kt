package io.github.aphelium.modules.coin.dtos

import javax.validation.constraints.NotBlank

class CreateFiatDTO {
    val name: @NotBlank(message = "The name is mandatory") String? = null
    val description: @NotBlank(message = "The description is mandatory") String? = null
    val code: @NotBlank(message = "The code is mandatory") String? = null
    val isActive: Boolean? = null
    val country: @NotBlank(message = "The country is mandatory") String? = null
}