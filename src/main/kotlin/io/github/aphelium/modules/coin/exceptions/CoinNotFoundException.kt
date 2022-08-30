package io.github.aphelium.modules.coin.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Coin not found")
class CoinNotFoundException : RuntimeException()