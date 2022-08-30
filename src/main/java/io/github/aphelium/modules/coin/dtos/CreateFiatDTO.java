package io.github.aphelium.modules.coin.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class CreateFiatDTO {

    @NotBlank(message = "The name is mandatory")
    private String name;
    @NotBlank(message = "The description is mandatory")
    private String description;
    @NotBlank(message = "The code is mandatory")
    private String code;
    private Boolean isActive;
    @NotBlank(message = "The country is mandatory")
    private String country;

}
