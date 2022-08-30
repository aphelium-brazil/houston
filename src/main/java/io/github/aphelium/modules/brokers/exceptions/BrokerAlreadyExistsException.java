package io.github.aphelium.modules.brokers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Broker already exists")
public class BrokerAlreadyExistsException extends RuntimeException {
}
