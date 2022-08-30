package io.github.aphelium.modules.brokers.dtos

import javax.validation.constraints.NotBlank

class AddCoinToBrokerDTO {
    var coin: @NotBlank(message = "The coin id is mandatory") String? = null
}