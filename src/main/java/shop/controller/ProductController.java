package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.Product;
import shop.service.ProductService;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
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

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String allProducts(Model model) {

        model.addAttribute("products", service.selectAll());
        return "allProducts";
    }

    @RequestMapping(value = "/id={id}", method = RequestMethod.GET)
    public String product(@PathVariable Integer id, Model model) {

        model.addAttribute("product", service.getById(id));
        return "product";
    }
}



