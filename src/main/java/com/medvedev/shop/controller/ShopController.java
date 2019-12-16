package com.medvedev.shop.controller;

import com.medvedev.shop.model.Product;
import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.service.ProductService;
import com.medvedev.shop.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ShopController  {

    private PurchaseService purchaseService;

    private ProductService productService;

    public ShopController(PurchaseService purchaseService, ProductService productService) {
        this.purchaseService = purchaseService;
        this.productService = productService;
    }


    //-----------------
    //Security
    //-----------------
    @RequestMapping("/")
    public String home () {
        return "home";
    }

    @RequestMapping("/hello")
    public String hello () {
        return "hello";
    }

    //-----------------



    @RequestMapping("/purchase")
    public String getAllPurchase (Model model) {
        List<Purchase> purchases = purchaseService.findAll();
        model.addAttribute("purchases",purchases);
      return "purchase";
    }

    @RequestMapping("/products")
    public String getAllProducts (Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @RequestMapping("/basket")
    public String fallthroughBasket (Model model, @RequestParam(name = "id") Long id) {
        List<Product> products = productService.findProductToPurchase(id);
        model.addAttribute("products",products);
        return "fallthroughPurchase";
    }

    @RequestMapping("/productsWeek")
    public String productsWeek (Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    //-----------------
    //CRUD Purchase
    //-----------------
    @RequestMapping("/deleteById")
    public String deleteById (@RequestParam(name = "id") Long id) {
        purchaseService.deleteById(id);
        return "redirect:purchase";
    }



    @RequestMapping("/createPurchase")
    public String newCreatePurchase () {
        return "createPurchase";
    }

    @RequestMapping(value = "/newCreatePurchase",method = RequestMethod.POST)
    public String createPurchase (
            @RequestParam(name = "name") String name,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "count") int count,
            @RequestParam(name = "amount") float amount) {
        purchaseService.create(name,lastName,age,count,amount);
        return "redirect:purchase";
    }




    @RequestMapping("/updateById")
    public String updateById (Model model,@RequestParam(name = "id") Long id) {
        Purchase purchase = purchaseService.findById(id);
        model.addAttribute("purchase",purchase);
        return "updateAndPurchase";
    }


    @RequestMapping(value = "/updatePurchase",method = RequestMethod.POST)
    public String updatePurchase (

            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "count") int count,
            @RequestParam(name = "amount") float amount) {

        Purchase purchase = new Purchase(id,name,lastName,age,count,amount);

        purchaseService.updatePurchase(purchase);
        return "redirect:purchase";
    }
}