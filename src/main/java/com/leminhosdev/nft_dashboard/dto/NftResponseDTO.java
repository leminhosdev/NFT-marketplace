package com.leminhosdev.nft_dashboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NftResponseDTO {

    private String name;
    private Double floorPrice;
    private String bannerImageUrl;
    private String featuredImageUrl;

    public NftResponseDTO(String name, Double floorPrice, String featuredImageUrl, String bannerImageUrl) {
        this.name = name;
        this.floorPrice = floorPrice;
        this.featuredImageUrl = featuredImageUrl;
        this.bannerImageUrl = bannerImageUrl;
    }

    public NftResponseDTO() {
    }
}
