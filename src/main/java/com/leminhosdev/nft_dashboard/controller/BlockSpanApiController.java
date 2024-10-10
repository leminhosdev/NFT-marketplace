package com.leminhosdev.nft_dashboard.controller;

import com.leminhosdev.nft_dashboard.service.BlockSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/blockspan")
public class BlockSpanApiController {

    @Autowired
    private BlockSpanService blockSpanService;

    @GetMapping
    public ResponseEntity<String> getInformations(){
        String information = blockSpanService.getInformation();
        return ResponseEntity.ok(information);
    }
}
