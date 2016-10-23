package guru.springframework.controllers;

import guru.springframework.domain.Contact;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user/new")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());

        return "registeruser";

    }


    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.registerUser(user.getFullName(), user.getLogin(), user.getPassword());
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("userlogin")
    public String userLogin(Model model) {
        //TODO LOGIN LOGIC

        return "userlogin";
    }

    @RequestMapping("addcontact/new")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());

        return "addcontact";
    }

    //TODOO user.getId for saving contact

    @RequestMapping(value = "contact", method = RequestMethod.POST)
    public String saveContact(Contact contact) {
        userService.addContact(contact.getFirstName(),contact.getSecondName(),
                contact.getFathersName(),contact.getMobilePhoneNumber(),contact.getHomePhoneNumber(),
                contact.getHomeAddress(),contact.getEmail(),0);
        return "redirect:/user/" + contact.getId();
    }

    @RequestMapping("usercabinet")
    public String userCabinet(){
        return "usercabinet";
    }


}
