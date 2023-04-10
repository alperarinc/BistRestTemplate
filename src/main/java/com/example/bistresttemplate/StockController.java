package com.example.bistresttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    private final AlphaVantageClient alphaVantageClient;

    public StockController(AlphaVantageClient alphaVantageClient) {
        this.alphaVantageClient = alphaVantageClient;
    }


    @GetMapping("/stock/{symbol}")
    public String getStockData(@PathVariable String symbol) {
        String stockData = alphaVantageClient.getStockData(symbol);

        return stockData;
    }
}
