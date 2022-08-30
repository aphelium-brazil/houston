package io.github.aphelium.modules.coin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Fiat already exists")
public class FiatAlredyExistsException extends RuntimeException {
}
