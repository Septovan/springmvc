package id.tokoonderdil.study.springmvc.controller;

import id.tokoonderdil.study.springmvc.domain.User;
import id.tokoonderdil.study.springmvc.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"/list", "/"})
    public String listUser(Model model) {
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    @RequestMapping("show/{userId}")
    public String getUser(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user/show";
    }

    @RequestMapping("/edit/{userId}")
    public String editUser(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user/userform";
    }

    @RequestMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/userform";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String saveOrUpdate(User user) {
        User savedUser = userService.saveOrUpdate(user);
        return "redirect:/user/show/" + savedUser.getObjectId();
    }
}
