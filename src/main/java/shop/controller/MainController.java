package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.User;
import shop.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String startPage() {
        return "startPage";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(User user) {
        if (userService.entityExists(user)) {
            return "wrongUser";
        } else {
            userService.addEntity(user);
            return "login";
        }
    }

    @RequestMapping(value = {"/menu-user"}, method = RequestMethod.GET)
    public String menuUser() {
        return "menuUser";
    }

    @RequestMapping(value = {"/menu-admin"}, method = RequestMethod.GET)
    public String menuAdmin() {
        return "menuAdmin";
    }

    @RequestMapping(value = {"/menu"}, method = RequestMethod.GET)
    public String menu() {
        return "menu";
    }

}


