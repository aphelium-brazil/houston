package io.github.aphelium.modules.brokers.dtos;

import io.github.aphelium.modules.coin.enums.CoinType;

import javax.validation.constraints.NotBlank;

public class AddCoinToBrokerDTO {

    @NotBlank(message = "The coin id is mandatory")
    public String coin;

}
