package com.product.controller;


import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("products", service.findallProducts());
        return "all-products";
    }

    @GetMapping("/add")
    public String lunchAddProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/addproduct")
    public String createProduct(Product product) {
        service.addProduct(product);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", service.findProductById(id));
        return "edit-product";

    }

    @PostMapping("/updateproduct")
    public String upadteProduct(Product product) {
        service.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test() {
        Product st = new Product();
        st.setId(1);
        st.setSize("XL");
        st.setType("Shirt");
        st.setColour("blue");
        st.setBrand("GAP");
        service.addProduct(st);
        return "index";

    }
}
