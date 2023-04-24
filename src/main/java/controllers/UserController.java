package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import components.UserData;
import services.UserDataService;
import services.UserDataServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

//	@Autowired
//	UserDataService userDataService;
//
//	@GetMapping("/usersRaport")
//	public String lodeEmployee(Model m)
//	{
//		UserData wiktor = new UserData(11,"istachuui@wp.pl","Wiktor","koniec");
//		UserData andrzej = new UserData(12,"esssa@wp.pl","andrzej","dzisiaj");
//		userDataService.addUser(andrzej);
//		userDataService.addUser(wiktor);
//		userDataService.deleteUser(6);
//		userDataService.updateUser(7);
//		m.addAttribute("users", userDataService.getAllUsers());
//		m.addAttribute("title", "Users Raport");
//		
//		return "home-page1";
//	}
}
