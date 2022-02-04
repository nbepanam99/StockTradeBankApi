package com.hackerrank.stocktrades.controller;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockTradeRestController {

    @Autowired
    StockTradeRepository stockTradeRepository;

    public StockTradeRestController(StockTradeRepository stockTradeRepository) {
        this.stockTradeRepository = stockTradeRepository;
    }

    @PostMapping(path = "/trades")
    public ResponseEntity<StockTrade> saveTrade(StockTrade stockTrade){

        StockTrade save = stockTradeRepository.save(stockTrade);

        return ResponseEntity.status(HttpStatus.valueOf(201)).body(save);
    }

    @GetMapping(path = "/trades")
    public ResponseEntity<List<StockTrade>> getTrade(){

        List<StockTrade> all = stockTradeRepository.findAll();
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(all);
    }

    @DeleteMapping(path = "/trades/{id}")
    public ResponseEntity<StockTrade> deleteTrade(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.valueOf(405)).build();
    }

    @PutMapping(path = "/trades/{id}")
    public ResponseEntity<StockTrade> putTrade(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.valueOf(405)).build();
    }

    @PatchMapping(path = "/trades/{id}")
    public ResponseEntity<StockTrade> patchTrade(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.valueOf(405)).build();
    }



}
