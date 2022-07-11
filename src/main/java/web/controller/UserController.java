package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("username") String username,
                               @ModelAttribute("password") String password,
                               User user) {
        user.setUsername(username);
        user.setPassword(password);
        userService.add(user);
        return "registration";
    }

    @GetMapping("/admin")
    public String userList(Model model){
        List<User> allUsers = userService.allUsers();
        model.addAttribute("allUsers", allUsers);
        return "admin";
    }

    @GetMapping("/admin/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String users(Model model, Principal principal){
        User user = userService.getUserByName(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }



}