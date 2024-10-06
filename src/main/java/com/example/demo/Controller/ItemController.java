package com.example.demo.Controller;

import com.example.demo.DTO.BuyItemDTO;
import com.example.demo.DTO.ItemDTO;
import com.example.demo.Entity.Item;
import com.example.demo.Services.ItemService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/sellItem")
    public ResponseEntity<String> sellItem(@RequestBody ItemDTO itemDTO){
        return itemService.sellItem(itemDTO);
    }

    @GetMapping("/unSoldItems")
    public ResponseEntity<List<Item>> notSoldItem(@RequestParam("sellerName") String sellerName){
        return itemService.getUnSoldItemsBySeller(sellerName);
    }

    @GetMapping("/soldItems")
    public ResponseEntity<List<Item>> soldItem(@RequestParam("sellerName") String sellerName){
        return itemService.getSoldItemsBySeller(sellerName);
    }

    @GetMapping("/buyItems")
    public ResponseEntity<List<Item>> buyItem(@RequestParam("BuyerName") String BuyerName){
        return itemService.getUnSoldItemsByBuyer(BuyerName);
    }

    @PostMapping("/buyItem")
    public ResponseEntity<String> buyItem(@RequestBody BuyItemDTO buyItemDTO){
        return itemService.buyItem(buyItemDTO);
    }
}
