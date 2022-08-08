package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepo shRepo;

    @Autowired
    public ShopServiceImpl(ShopRepo sRepo){
        this.shRepo =sRepo;
    }


    @Override
    public boolean createShop(Shop shop) {
        int pk = shRepo.save(shop).getId();

        return (pk > 0) ? true:false;
    }

    @Override
    public Candy getShopId(int id) {
        return null;
    }

    @Override
    public List<Candy> getAllShop() {
        return null;
    }

    @Override
    public Shop getShopById(int id) {
        try {

            Optional<Shop> target = shRepo.findById(id);
            Shop shop = target.get();

            return shop;

        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }


        return null;
    }

    @Override
    public List<Shop> getAllShops() {
        return shRepo.findAll();
    }

    @Override
    public boolean updateShop(Shop shop) {
        return shRepo.update(shop.getShopName(), shop.getInventoryCount(), shop.getId());
    }

    @Override
    public boolean deleteShop(Shop shop) {
        shRepo.delete(shop);
        return true;
    }
}