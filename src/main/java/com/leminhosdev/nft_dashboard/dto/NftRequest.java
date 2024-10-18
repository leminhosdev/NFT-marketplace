package com.leminhosdev.nft_dashboard.dto;

public record NftRequest(String contractAddress, String chain, String pageSize) {
}
