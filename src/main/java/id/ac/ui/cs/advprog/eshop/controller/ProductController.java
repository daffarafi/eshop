package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
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
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
        service.delete(productId);
        return "redirect:/product/list";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int productId, @ModelAttribute Product product, Model model) {
        service.editProduct(productId, product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") int productId, Model model) {
        Product product = service.getProductById(productId);
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

@Controller
@RequestMapping("/car")
class CarController extends ProductController{
    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        carService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model) {
        List<Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        System.out.println(car.getCarId());
        carService.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId) {
        carService.deleteCarById(carId);
        return "redirect:listCar";
    }
}