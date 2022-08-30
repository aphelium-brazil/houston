package io.github.aphelium.modules.brokers.dtos

import javax.validation.constraints.NotBlank

class CreateBrokerDTO {
    var name: @NotBlank(message = "The name is mandatory") String? = null
    var description: @NotBlank(message = "The description is mandatory") String? = null
    var slug: @NotBlank(message = "The slug is mandatory") String? = null
    var logo: @NotBlank(message = "The logo is mandatory") String? = null
    var dateLaunched: @NotBlank(message = "The date launched is mandatory") String? = null
}