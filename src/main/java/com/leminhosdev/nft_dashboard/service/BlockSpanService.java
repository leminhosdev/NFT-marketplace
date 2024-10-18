package com.leminhosdev.nft_dashboard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leminhosdev.nft_dashboard.dto.NftRequest;
import com.leminhosdev.nft_dashboard.dto.NftResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BlockSpanService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${blockspan.api.key}")
    private String blockSpanApiKey;

    private static final String blockSpanUrl = "https://api.blockspan.com";

    public NftResponseDTO getNFTPrice(NftRequest nftRequest) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();

        headers.set("accept", "application/json");
        headers.set("X-API-KEY",blockSpanApiKey);

        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(blockSpanUrl + "/v1/collections/contract/");
        stringBuilder.append(nftRequest.contractAddress());

        String url = stringBuilder.toString();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.getBody());

        JsonNode exchangeData =rootNode.get("exchange_data").get(1);
        JsonNode statsNode = exchangeData.get("stats");

        NftResponseDTO nftResponseDTO = new NftResponseDTO();

        nftResponseDTO.setName(exchangeData.path("name").asText());
        nftResponseDTO.setFloorPrice(statsNode.path("floor_price").asDouble());
        nftResponseDTO.setBannerImageUrl(exchangeData.path("banner_image_url").asText());
        nftResponseDTO.setFeaturedImageUrl(exchangeData.path("featured_image_url").asText());

        return nftResponseDTO;
    }
}
