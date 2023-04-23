package com.example.bistresttemplate.api;

import com.example.bistresttemplate.client.AlphaVantageClient;
import com.example.bistresttemplate.model.StockResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/stocks")
public class StockController {
    private final AlphaVantageClient alphaVantageClient;

    public StockController(AlphaVantageClient alphaVantageClient) {
        this.alphaVantageClient = alphaVantageClient;
    }


    @GetMapping("{symbol}")
    public ResponseEntity<StockResponse> getStockData(@PathVariable String symbol) {
        return ResponseEntity.ok(alphaVantageClient.getStockData(symbol));
    }
}
