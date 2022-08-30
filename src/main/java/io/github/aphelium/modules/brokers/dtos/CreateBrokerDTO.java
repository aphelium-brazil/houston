package io.github.aphelium.modules.brokers.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBrokerDTO {

    @NotBlank(message = "The name is mandatory")
    private String name;
    @NotBlank(message = "The description is mandatory")
    private String description;
    @NotBlank(message = "The slug is mandatory")
    private String slug;
    @NotBlank(message = "The logo is mandatory")
    private String logo;
    @NotBlank(message = "The date launched is mandatory")
    private String dateLaunched;

}
