package io.github.aphelium.modules.brokers.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Broker not found")
public class BrokerNotFoundException extends RuntimeException {
}
