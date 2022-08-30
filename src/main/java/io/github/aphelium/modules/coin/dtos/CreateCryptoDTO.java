package io.github.aphelium.modules.coin.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCryptoDTO {

    @NotBlank(message = "The name is mandatory")
    private String name;
    @NotBlank(message = "The description is mandatory")
    private String description;
    @NotBlank(message = "The code is mandatory")
    private String code;
    private Boolean isActive;
    private String logo;
    @NotBlank(message = "The first historical date is mandatory")
    private String firstHistoricalDate;
    private String lastHistoricalDate;


}
