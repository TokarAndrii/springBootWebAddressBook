package guru.springframework.controllers;

import guru.springframework.domain.Contact;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import guru.springframework.utils.UserInSystemFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "registeruser";
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String userLogin(Model model) {

        model.addAttribute("user", new User());
        return "loginformuser";
    }

    @RequestMapping(value = "/save/contact", method = RequestMethod.POST)
    public String saveContact(Contact contact) {


        String firstName = contact.getFirstName();
        String secondName = contact.getSecondName();
        String fathersName = contact.getFathersName();
        String mobilePhoneNumber = contact.getMobilePhoneNumber();
        String homePhoneNumber = contact.getHomePhoneNumber();
        String address = contact.getHomeAddress();
        String email = contact.getEmail();

        UserInSystemFinder userInSystemFinder = new UserInSystemFinder();
        userInSystemFinder.setUserService(userService);
        long userId = userInSystemFinder.userInSystem();


        userService.addContact(firstName, secondName, fathersName,
                mobilePhoneNumber, homePhoneNumber, address, email, userId);

        return "usercabinet";

    }


    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveUser(User user) {

        String fullName = user.getFullName();
        String login = user.getLogin();
        String password = user.getPassword();

        userService.registerUser(fullName, login, password);
        return "loginformuser";
    }

    @RequestMapping("/user/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }


    @RequestMapping("/contact/new")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "addcontact";
    }


    @RequestMapping("/usercabinet")
    public String userCabinet(Model model) {

        return "usercabinet";
    }


    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String list(Model model) {


        UserInSystemFinder userInSystemFinder = new UserInSystemFinder();
        userInSystemFinder.setUserService(userService);
        Long foundId = userInSystemFinder.userInSystem();


        model.addAttribute("contacts", userService.findContactsByUserId(foundId));
        return "usercabinet";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @RequestMapping(value = "/contact/delete/{id}")
    public String deleteContact(@PathVariable long id) {
        /*Contact found = userService.findContactById(id);*/
        userService.deleteContact(id);
        return "usercabinet";
    }


}
