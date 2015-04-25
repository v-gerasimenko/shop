package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.Product;
import shop.entity.User;
import shop.service.ProductService;
import shop.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String createSession(User user, HttpServletRequest request) {

        if (userService.entityExists(userService.getByLoginAndPassword(user.getLogin(),
                user.getPassword()))) {
            User newUser = userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
            if (newUser.getRole().equals("admin")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("name", newUser.getLogin());
                return "menuAdmin";

            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("name", newUser.getLogin());
                return "menuUser";
            }
        } else {
            return "wrongValidation";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
       HttpSession session = request.getSession();
        session.invalidate();
        return "logout";
    }


}


