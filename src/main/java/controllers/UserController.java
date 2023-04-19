package controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import components.UserData;
import components.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ModelAndView listUsers() {
        Iterable<UserData> userDataIterable  = userRepository.findAll();
        List<UserData> users = new ArrayList<>();
        for (UserData userData : userDataIterable) {
            users.add(userData);
        }
        ModelAndView mav = new ModelAndView("user/list");
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") Long id) throws NotFoundException {
        UserData user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        ModelAndView mav = new ModelAndView("user/view");
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("user/form");
        mav.addObject("user", new UserData());
        return mav;
    }
}
