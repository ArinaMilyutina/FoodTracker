package com.example.foodtracker.controller;

import com.example.foodtracker.dto.ProductDto;
import com.example.foodtracker.entity.product.Product;
import com.example.foodtracker.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String PRODUCT = "product";
    private static final String MESSAGE = "message";
    private static final String CREATE_PRODUCT = "The product was created successfully.";
    private static final String NOT_CREATE_PRODUCT = "The product already exists!!!";
    private static final String TRUE = "true";
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private String createProduct(Model model) {
        model.addAttribute(PRODUCT, new ProductDto());
        return "product";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private String createProduct(@ModelAttribute(PRODUCT) @Valid ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "product";
        }
        if (productService.findProductByBarcode(productDto.getBarcode()).equals(TRUE) && productService.findProductByProductName(productDto.getProductName()).equals(TRUE)) {
            model.addAttribute(MESSAGE, NOT_CREATE_PRODUCT);
            return "product";
        }
        Product product = Product.builder()
                .productName(productDto.getProductName())
                .barcode(productDto.getBarcode())
                .proteins(productDto.getProteins())
                .carbohydrates(productDto.getCarbohydrates())
                .fats(productDto.getFats())
                .calories(productDto.getCalories()).build();
        productService.createProduct(product);
        model.addAttribute(MESSAGE, CREATE_PRODUCT);
        return "product";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getProductByName(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.findProductByName(name);
        model.addAttribute(PRODUCT, products);
        return "home";
    }


}
