package com.example.demo.Services.Implementation;

import com.example.demo.DTO.BuyItemDTO;
import com.example.demo.DTO.ItemDTO;
import com.example.demo.Entity.Item;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> sellItem(ItemDTO itemDTO){
        Optional<User> sellerObject = userRepository.findUserByName(itemDTO.getSellerName());
        if(sellerObject.isEmpty()) return ResponseEntity.status(404).body("User not found");
        Item seller=new Item(itemDTO.getName(),itemDTO.getCategory(),itemDTO.getQuantity(),itemDTO.getPrice(),false,sellerObject.get(),null);
        itemRepository.save(seller);
        return ResponseEntity.status(200).body("item added by seller Successfully");
    }

    @Override
    public ResponseEntity<List<Item>> getUnSoldItemsBySeller(String sellerName) {
        Optional<User> sellerObject = userRepository.findUserByName(sellerName);
        if(sellerObject.isEmpty()) return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(itemRepository.findBySellerNameAndIsSoldIs(sellerObject.get(),false));
    }

    @Override
    public ResponseEntity<List<Item>> getSoldItemsBySeller(String sellerName) {
        Optional<User> sellerObject = userRepository.findUserByName(sellerName);
        if(sellerObject.isEmpty()) return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(itemRepository.findBySellerNameAndIsSoldIs(sellerObject.get(),true));
    }

    @Override
    public ResponseEntity<List<Item>> getUnSoldItemsByBuyer(String buyerName) {
        Optional<User> BuyerObject = userRepository.findUserByName(buyerName);
        if(BuyerObject.isEmpty()) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(itemRepository.findAllBySellerNameNotAndIsSoldIs(BuyerObject.get(),false));
    }

    @Override
    public ResponseEntity<String> buyItem(BuyItemDTO itemDTO) {
        Optional<Item> itemToBuy = itemRepository.findById(itemDTO.getItemId());
        if(itemToBuy.isEmpty()) return ResponseEntity.status(404).body("Item not found");
        Optional<User> buyer = userRepository.findUserByName(itemDTO.getName());
        if(buyer.isEmpty()) return ResponseEntity.status(404).body("Buyer not found");
        if(itemToBuy.get().getSellerName().getId() == buyer.get().getId()){
            return ResponseEntity.status(403).body("You can not buy this product!!!");
        }
        if(itemToBuy.get().isSold()){
            return ResponseEntity.status(403).body("You can not buy sold product!!!");
        }

        itemToBuy.get().setQuantity(0);
        itemToBuy.get().setBuyerName(buyer.get());
        itemToBuy.get().setSold(true);

        itemRepository.save(itemToBuy.get());

        return ResponseEntity.ok("Item bought successfully");
    }

}
