package com.example.demo.Repository;

import com.example.demo.Entity.Item;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findItemsBySellerNameAndSoldIs(User user, boolean sold);

    List<Item> findBySellerNameAndIsSoldIs(User sellerName,boolean isSold);

    List<Item> findAllBySellerNameNotAndIsSoldIs(User sellerName,boolean isSold);
}
