package com.example.bistresttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlphaVantageClient {

    private static final String API_KEY = "MW3EX8F87UOU3E3A";
    private static final String BASE_URL = "https://www.alphavantage.co/query";

    @Autowired
    private final RestTemplate restTemplate;

    public AlphaVantageClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getStockData(String symbol) {
        String url = BASE_URL + "?function=TIME_SERIES_INTRADAY&interval=5min&symbol=" + symbol + ".IS&apikey=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}


