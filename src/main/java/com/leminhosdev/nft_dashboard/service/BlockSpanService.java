package com.leminhosdev.nft_dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

@Service
public class BlockSpanService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${blockspan.api.key}")
    private String blockSpanApiKey;

    private static final String blockSpanUrl = "https://api.blockspan.com";

    public String getInformation(){

        HttpHeaders headers = new HttpHeaders();

        headers.set("accept", "application/json");
        headers.set("X-API-KEY",blockSpanApiKey);

        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);


        String url = blockSpanUrl + "/v1/collections/owner/0xf9A6318a605Db1839682C22F54537CBb68276c28?chain=eth-main&page_size=25";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return response.getBody();
    }
}
