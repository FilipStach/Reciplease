package controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import components.UserData;
import components.UserRepository;
import services.UserDataService;
//import components.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDataService userDataService;

	@GetMapping("/usersRaport")
	public String lodeEmployee(Model m)
	{
		UserData wiktor = new UserData(11,"istachui@wp.pl","Wiktor","lampa1");
		UserData andrzej = new UserData(12,"esssa@wp.pl","andrzej","krzeslo1");
//		UserDataService userDataService = new UserDataService();
		userDataService.addUser(andrzej);
		userDataService.addUser(wiktor);
		m.addAttribute("users", userDataService.getAllUsers());
		m.addAttribute("title", "Users Raport");
		
		return "home-page";
	}
}
