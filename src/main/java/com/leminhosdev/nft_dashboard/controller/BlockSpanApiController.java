package com.leminhosdev.nft_dashboard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leminhosdev.nft_dashboard.dto.NftRequest;
import com.leminhosdev.nft_dashboard.dto.NftResponseDTO;
import com.leminhosdev.nft_dashboard.service.BlockSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/blockspan")
public class BlockSpanApiController {

    @Autowired
    private BlockSpanService blockSpanService;

    @GetMapping
    public ResponseEntity<NftResponseDTO> getNFTPrice(@RequestBody NftRequest nftRequest) throws JsonProcessingException {
        NftResponseDTO nftResponseDTO = blockSpanService.getNFTPrice(nftRequest);
        return ResponseEntity.ok(nftResponseDTO);
    }
}
