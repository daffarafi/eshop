package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    //    private final ProductServiceImpl service;
//
//    @Autowired
//    public ProductController(ProductServiceImpl service) {
//        this.service = service;
//    }
    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String productId) {
        service.delete(productId);
        return "redirect:/product/list";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") String productId, @ModelAttribute Product product, Model model) {
        service.update(productId, product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String productId, Model model) {
        Product product = service.find(productId);
        model.addAttribute("product", product);
        model.addAttribute("id", productId);
        return "EditProduct";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ListProduct";
    }
}
