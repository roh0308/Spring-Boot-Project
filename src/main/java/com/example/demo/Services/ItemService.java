package com.example.demo.Services;

import com.example.demo.DTO.BuyItemDTO;
import com.example.demo.DTO.ItemDTO;
import com.example.demo.Entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<String> sellItem(ItemDTO itemDTO);

    ResponseEntity<List<Item>> getUnSoldItemsBySeller(String sellerName);

    ResponseEntity<List<Item>> getSoldItemsBySeller(String sellerName);

    ResponseEntity<List<Item>> getUnSoldItemsByBuyer(String BuyerName);

    ResponseEntity<String> buyItem(BuyItemDTO itemDTO);

}
