package io.github.aphelium.repository;


import io.github.aphelium.models.Coin;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoinsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Coin save(@NotNull Coin coin) {
        jdbcTemplate.update("INSERT INTO coins (" +
                        "id, " +
                        "name, " +
                        "description, " +
                        "isActive, " +
                        "isFiat, " +
                        "logo, " +
                        "symbol, " +
                        "firstHistoricalData, " +
                        "lastHistoricalData, " +
                        "country, " +
                        "category, " +
                        "techDoc, " +
                        "sourceCode, " +
                        "platform, " +
                        "createdAt, " +
                        "updatedAt, " +
                        "deletedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                coin.getId(),
                coin.getName(),
                coin.getDescription(),
                coin.getActive(),
                coin.getFiat(),
                coin.getLogo(),
                coin.getSymbol(),
                coin.getFirstHistoricalData(),
                coin.getLastHistoricalData(),
                coin.getCountry().getId(),
                coin.getCategory().getId(),
                coin.getTechDoc().getId(),
                coin.getSourceCode().getId(),
                coin.getPlatform().getId(),
                coin.getCreatedAt(),
                coin.getUpdatedAt(),
                coin.getDeletedAt());
        return coin;
    }

}
