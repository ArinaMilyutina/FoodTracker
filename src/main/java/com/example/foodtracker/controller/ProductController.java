package com.example.foodtracker.controller;

import com.example.foodtracker.dto.ProductDto;
import com.example.foodtracker.entity.product.FoodValue;
import com.example.foodtracker.entity.product.Product;
import com.example.foodtracker.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String PRODUCT = "product";
    private static final String MESSAGE = "message";
    private static final String CREATE_PRODUCT = "The product was created successfully.";
    private static final String NOT_CREATE_PRODUCT = "The product already exists!!!";
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private String createProduct(Model model) {
        model.addAttribute(PRODUCT, new ProductDto());
        return "createProduct";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private String createProduct(@ModelAttribute(PRODUCT) @Valid ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createProduct";
        }
        if (productService.findProductByBarcode(productDto.getBarcode()).equals("true")) {
            model.addAttribute(MESSAGE, NOT_CREATE_PRODUCT);
            return "createProduct";
        }
        Product product = Product.builder()
                .barcode(productDto.getBarcode())
                .productName(productDto.getProductName())
                .foodValue(FoodValue.builder().calories(productDto.getCalories()).carbohydrates(productDto.getCarbohydrates()).fats(productDto.getFats()).proteins(productDto.getProteins()).build())
                .build();
        productService.createProduct(product);
        model.addAttribute(MESSAGE, CREATE_PRODUCT);
        return "createProduct";
    }
}
