package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.Product;
import shop.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@Scope("session")
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
            return "product_incorrect";
        else if (service.entityExists(product))
            return "product_exists";
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

    @RequestMapping(value = "/add-product/id={id}", method = RequestMethod.GET)
    public String productAdd(@PathVariable Integer id, HttpServletRequest request) {

                Product product = service.getById(id);
                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>)
                        session.getAttribute("productsInBucket");
                AtomicLong totalPrice = (AtomicLong)
                        session.getAttribute("total");
                if (oldBucket == null && totalPrice == null) {
                    session.setAttribute("productsInBucket",
                            Collections.singletonMap(product, 1));
                    totalPrice = new AtomicLong(0);
                    session.setAttribute("total",
                            totalPrice.addAndGet(product.getPrice()));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if (!oldBucket.containsKey(product)) {
                        newBucket.put(product, 1);
                        totalPrice.addAndGet(product.getPrice());
                    } else {
                        newBucket.put(product, newBucket.get(product) + 1);
                        totalPrice.addAndGet(product.getPrice());
                    }
                    session.setAttribute("productsInBucket",
                            Collections.unmodifiableMap(newBucket));
                }
                session.setAttribute("total", totalPrice);
                String newLocation = "/product/id=" + id;

        return "redirect:" + newLocation;
    }
}



