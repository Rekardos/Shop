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



    @RequestMapping("/purchases")
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

    @RequestMapping("/fallthroughPurchase")
    public String fallthroughPurchase (Model model, @RequestParam(name = "id") Long id) {
        List<Product> products = productService.findProductToPurchase(id);
        model.addAttribute("products",products);
        return "fallthroughPurchase";
    }




    @RequestMapping("/deleteById")
    public String deletePurchaseById (@RequestParam(name = "id") Long id) {
        purchaseService.deleteById(id);
        return "redirect:purchase";
    }



    @RequestMapping("/createPurchaseView")
    public String createPurchaseView () {
        return "createPurchase";
    }

    @RequestMapping(value = "/createPurchase",method = RequestMethod.POST)
    public String createPurchase (
            @RequestParam(name = "name") String name,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "count") int count,
            @RequestParam(name = "amount") float amount) {

        purchaseService.create(name,lastName,age,count,amount);
        return "redirect:purchases";
    }


    @RequestMapping("/updateById")
    public String updatePurchaseById (Model model, @RequestParam(name = "id") Long id) {
        Purchase purchase = purchaseService.findById(id);
        model.addAttribute("purchase",purchase);
        return "updatePurchase";
    }


    @RequestMapping(value = "/updatePurchase",method = RequestMethod.POST)
    public String updatePurchase (@RequestParam(name = "id") Long id, @ModelAttribute(name = "purchase") Purchase purchase){
        purchase.setId(id);
        purchaseService.updatePurchase(purchase);
        return "redirect:purchases";
    }
}