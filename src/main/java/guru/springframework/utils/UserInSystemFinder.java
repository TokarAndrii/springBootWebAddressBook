package guru.springframework.utils;

import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInSystemFinder {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserInSystemFinder() {
    }

    public long userInSystem() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User found = userService.findUserByName(userDetails.getUsername());
        Long foundId = found.getId();

        return foundId;
    }


}
