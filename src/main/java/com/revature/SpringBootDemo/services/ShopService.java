package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.Shop;

import java.util.List;

public interface ShopService {

    //creates a new candy
    boolean createShop(Shop shop);

    //get shop by Id
    Candy getShopId(int id);

    //get all candies
    List<Candy> getAllShop();

    Shop getShopById(int id);

    List<Shop> getAllShops();

    //update a candy
    boolean updateShop(Shop shop);

    //delete a shop
    boolean deleteShop(Shop shop);
}
