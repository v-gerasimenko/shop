package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.Product;
import shop.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productEnter";
    }


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String newProduct(@Valid Product product, Errors result) {

        if (result.hasErrors())
            return "error400";
        else if (service.entityExists(product))
            return "error401";
        else {
            service.addEntity(product);
            return "correct";
        }
    }
}



