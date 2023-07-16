package com.example.foodtracker.controller;

import com.example.foodtracker.dto.ProductDto;
import com.example.foodtracker.entity.product.NewProduct;
import com.example.foodtracker.entity.product.Product;
import com.example.foodtracker.service.ProductService;
import com.example.foodtracker.util.CalorieCounterForFoodUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String PRODUCT = "product";
    private static final String MESSAGE = "message";
    private static final String CREATE_PRODUCT = "The product was created successfully.";
    private static final String NOT_CREATE_PRODUCT = "The product already exists!!!";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String PRODUCT_NOT_FOUND = "Product not found!!!";
    @Autowired
    private ProductService productService;
    @Autowired
    private CalorieCounterForFoodUtil counter;

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
        if (productService.findProductByProductName(name).equals(FALSE)) {
            model.addAttribute(MESSAGE, PRODUCT_NOT_FOUND);
            return "home";
        }
        Product products = productService.findProductByName(name);
        model.addAttribute(PRODUCT, products);
        return "home";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    private String calculateProduct(Model model) {
        model.addAttribute("newProduct", new NewProduct());
        return "calculateProduct";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    private String calculateProduct(@Valid @ModelAttribute("newProduct") NewProduct newProduct, BindingResult bindingResult, Model model, Product product) {
        if (bindingResult.hasErrors()) {
            return "calculateProduct";
        }
        if (productService.findProductByProductName(product.getProductName()).equals(FALSE)) {
            model.addAttribute(MESSAGE, PRODUCT_NOT_FOUND);
            return "calculateProduct";
        }
        Product products = productService.findProductByName(product.getProductName());
        NewProduct newProduct1 = NewProduct.builder()
                .barcode(products.getBarcode())
                .countGram(newProduct.getCountGram())
                .productName(products.getProductName())
                .calories(counter.calculateCalories(newProduct.getCountGram(), products.getCalories()))
                .proteins(counter.calculateProteins(newProduct.getCountGram(), products.getProteins()))
                .fats(counter.calculateFats(newProduct.getCountGram(), products.getFats()))
                .carbohydrates(counter.calculateCarbohydrates(newProduct.getCountGram(), products.getCarbohydrates()))
                .build();
        productService.createNewProduct(newProduct1);
        model.addAttribute(PRODUCT, newProduct1);
        return "/calculateProduct";

    }


}