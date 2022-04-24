package com.lithan.ABC_Cars_Pte_Ltd.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;
import com.lithan.ABC_Cars_Pte_Ltd.service.CarService;
import com.lithan.ABC_Cars_Pte_Ltd.service.MyUserService;


@Controller
public class CarController {
String msg;
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	CarService carService;
	
	@Autowired
	MyUserService myservice;
	
	@GetMapping(value = "/")
	public String myHomePage() {
		return "home";	
	}
	
	@GetMapping(value = "/about")
	public String myAboutPage() {
		return "About";	
	}
	
	@GetMapping(value = "/contact")
	public String myContactPage() {
		return "Contact";	
	}
	
//	----------login----------
	
	
	@GetMapping(value = "/login")
	 public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


//	---register--
	@GetMapping(value = "/register")
	public String myRegisterPage(@ModelAttribute("register") User us) {
		return "registration";
		
	}
	@PostMapping(value = "/myreg")
	public String addRegisterPage(@ModelAttribute("register") User us,Model model) {
		String myreg = myservice.addUser(us);
//		String myuser = myservice.checkUser(us);
		if(myreg=="email exit") {
			model.addAttribute("email",true);
			
			return "registration";
		}
		
		if(myreg=="user exit") {
			model.addAttribute("user",true);
			
			return "registration";
		}
		return "redirect:/login";
		
	}
	
	
//	User Page
	
	@GetMapping("/user")
	public ModelAndView hello(@CurrentSecurityContext(expression="authentication?.name")
	                    String username) {
		System.out.println(username);
		 String myData = username;
		
	        return new ModelAndView("UserPage","show", myData);
	}
	
//	Add Car
	@GetMapping(value = "/user/add")
	public String myaddcarPage(@ModelAttribute("addPage") Car us) {
		return "UserAddCar";
		}
	
	@PostMapping(value = "/user/adddata")
	public String addProduct(
			@RequestParam("carName") String carName,
			@RequestParam("carModel") String carModel,
			@RequestParam("carPrice") Long carPrice,
			@RequestParam("carRegNumber") String carRegNumber,
			Model model,
            @RequestParam("manufaData") String manufaData,
            @RequestParam("file") MultipartFile file) {
		System.out.println(file);
		String fileName = file.getOriginalFilename().replaceAll(" ", "-");
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		long size = file.getSize();
		String fileSize = String.valueOf(size); 
		
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Car c=new Car();
		c.setCarName(carName);
	c.setCarModel(carModel);
	c.setCarPrice(carPrice);
	c.setCarRegNumber(carRegNumber);
	c.setFilePath(filePath);
	c.setFileSize(fileSize);
	c.setFileType(fileType);
	c.setImage(fileName);
	c.setManufaData(manufaData);
		System.out.println(c);
		String addPage=carService.addCar(c);
		if(addPage=="RegNumber exit") {
		model.addAttribute("email",true);
		return "UserAddCar";
	}
		return "redirect:/user/show";
	}

//	view car details
	@GetMapping(value = "/user/show")
	public ModelAndView UserShow() {
		List<Car> myData=carService.showAllStore();
		return new ModelAndView("Usershow","show", myData);
	}
	

	// profile
	@GetMapping(value = "/user/profile")
	public String myUserProfilePage() {
		return "UserProfile";
		
	}
	
	@GetMapping(value = "/user/profile/{username}")
	public ModelAndView UserProfileShow(@PathVariable("username") String profile) {
		User myData=myservice.findbyprofile(profile);
		return new ModelAndView("UserProfile","show", myData);
	}

	// profile update
	@GetMapping(value = "/user/profile/Update/{username}")
	public ModelAndView profileupdatePage(@PathVariable("username") String username) {
		User myData=myservice.profileupdate(username);
		return new ModelAndView("UpdateProfile","update", myData);	
	}
	
	@PostMapping(value = "/user/profile/Update/UserUpdate")
	public String profileupdateData(
			@RequestParam("userId") Long userId,
			@RequestParam("fullName") String fullName,
			@RequestParam("userName") String userName,
			@RequestParam("mailid") String mailid,
			@RequestParam("role") String role,
			Model model,
			@RequestParam("password") String password) {
		
		System.out.println(userName+" "+mailid+" "+role+" "+password+" 239");
		User pro = new User();
		pro.setFullName(fullName);
		pro.setUserId(userId);
		pro.setUserName(userName);
		pro.setMailid(mailid);
		pro.setRole(role);
		pro.setPassword(password);
		
		
		String addPage=myservice.profileupdateSave(pro);
		
		if(addPage=="email exit") {
		model.addAttribute("email",true);
		return "redirect:/user/profile/Update/"+userName+"?error=true";
	}
		
		return "redirect:/user";
		
	}

//	search
	
	@GetMapping(value = "/user/search")
	public String myuserSearchPage() {
		return "UserSearch";
		
	}
	
	@GetMapping(value = "/user/searchproduct")
	public ModelAndView myuserSearchData(
			@RequestParam("mysearch") String type,
			@RequestParam("searchid") String id,
			@RequestParam("searchminp") String minp,
			@RequestParam("searchmaxp") String maxp) {
		List<Car> p=null;
		
		System.out.println(type+" "+id+" "+minp+" "+maxp);
		if(type.equals("prodid")) {
			 p=carService.searchProduct(id);
		}else if(type.equals("prodprice")) {
		 p=carService.searchByPrice(Long.parseLong(minp), Long.parseLong(maxp));
		}
		System.out.println(p);
		return new ModelAndView("UserSearchshow","show", p);
		
	}

	
//	----------------- Admin---------------
	@GetMapping("/admin")
	public ModelAndView admin(@CurrentSecurityContext(expression="authentication?.name")
	                    String username) {
		System.out.println(username);
		 String myData = username;
		
	        return new ModelAndView("AdminPage","show", myData);
	}
	
	
//	 Add Car
	@GetMapping(value = "/admin/add")
	public String myAdminaddcarPage(@ModelAttribute("addPage") Car us) {
		return "AdminAddCar";
		}
	
	@PostMapping(value = "/admin/adddata")
	public String AdminaddProduct(
			@RequestParam("carName") String carName,
			@RequestParam("carModel") String carModel,
			@RequestParam("carPrice") Long carPrice,
			@RequestParam("carRegNumber") String carRegNumber,
			Model model,
            @RequestParam("manufaData") String manufaData,
            @RequestParam("file") MultipartFile file) {
		System.out.println(file);
		String fileName = file.getOriginalFilename().replaceAll(" ", "-");
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		long size = file.getSize();
		String fileSize = String.valueOf(size); 
		
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Car c=new Car();
		c.setCarName(carName);
	c.setCarModel(carModel);
	c.setCarPrice(carPrice);
	c.setCarRegNumber(carRegNumber);
	c.setFilePath(filePath);
	c.setFileSize(fileSize);
	c.setFileType(fileType);
	c.setImage(fileName);
	c.setManufaData(manufaData);
		System.out.println(c);
		String addPage=carService.addCar(c);
		if(addPage=="RegNumber exit") {
		model.addAttribute("email",true);
		return "AdminAddCar";
	}
		return "redirect:/admin/show";
	}
	
	@GetMapping(value = "/admin/show")
	public ModelAndView AdminShow() {
		List<Car> myData=carService.showAllStore();
		return new ModelAndView("Adminshow","show", myData);
	}
	
//	update Car Details

	@GetMapping(value = "/admin/update/{id}")
	public ModelAndView updatePage(@PathVariable("id") Integer id) {
		Car myData=carService.updateCarData(id);
		return new ModelAndView("UpdateCar","update", myData);	
	}
	
	@PostMapping(value = "/admin/update/CarUpdate")
	public String updateData(
			@RequestParam("cardId") Integer cardId,
			@RequestParam("carName") String carName,
			@RequestParam("carModel") String carModel,
			@RequestParam("carPrice") Long carPrice,
			@RequestParam("carRegNumber") String carRegNumber,
            @RequestParam("manufaData") String manufaData,
            @RequestParam("file") MultipartFile file) {
		System.out.println(file);
		String fileName = file.getOriginalFilename().replaceAll(" ", "-");
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		long size = file.getSize();
		String fileSize = String.valueOf(size); 
		
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Car c=new Car();
		c.setCardId(cardId);
		c.setCarName(carName);
	c.setCarModel(carModel);
	c.setCarPrice(carPrice);
	c.setCarRegNumber(carRegNumber);
	c.setFilePath(filePath);
	c.setFileSize(fileSize);
	c.setFileType(fileType);
	c.setImage(fileName);
	c.setManufaData(manufaData);
		System.out.println(c +" 325");
		carService.UpdateaddCar(c);
		
		return "redirect:/admin/show";
		
	}
	
//	delete Car Details
	@GetMapping(value ="deletedata")
	public String  deleteMyProduct (@RequestParam("cardId") Integer myid) {
		carService.deleteData(myid);
		return "redirect:/admin/show";
		
	}
	
//	 list of user
	@GetMapping(value = "/admin/listUser")
	public ModelAndView AdminlistUser() {
		List<User> myData=carService.showAllUser();
		return new ModelAndView("listUsershow","show", myData);
	}
	

//	delete user Details
	@GetMapping(value ="deletelistUser")
	public String deletelistUser(@RequestParam("cardId") Long Id) {
		myservice.deleteUser(Id);
		return "redirect:/admin/listUser";
		
	}
	
//	Update user Details
	@GetMapping(value = "/admin/listUser/update/{id}")
	public ModelAndView updatelistUserPage(@PathVariable("id") Long id) {
		User myData=myservice.updateData(id);
		return new ModelAndView("UpdatelistUser","update", myData);	
	}
	
	@PostMapping(value = "/admin/listUser/update/listUserUpdate")
	public String listUserupdateData(
			@RequestParam("userId") Long userId,
			@RequestParam("fullName") String fullName,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("mailid") String mailid,
			@RequestParam("role") String role
			)
			 {
		System.out.println(userId+" "+userName+" "+password+" "+mailid+" "+role+" "+" 275");
		User pro = new User();
		pro.setUserId(userId);
		pro.setFullName(fullName);
		pro.setUserName(userName);
		pro.setMailid(mailid);
		pro.setRole(role);
		pro.setPassword(password);
		
		myservice.UpdateaddUser(pro);
		System.out.println(pro+" 279");
		return "redirect:/admin/listUser";
		
	}
	
//	search
	
	@GetMapping(value = "/admin/search")
	public String myAdminSearchPage() {
		return "AdminSearch";
		
	}
	
	@GetMapping(value = "/admin/searchproduct")
	public ModelAndView myAdminSearchData(
			@RequestParam("mysearch") String type,
			@RequestParam("searchid") String id,
			@RequestParam("searchminp") String minp,
			@RequestParam("searchmaxp") String maxp) {
		List<Car> p=null;
		
		System.out.println(type+" "+id+" "+minp+" "+maxp);
		if(type.equals("prodid")) {
			 p=carService.searchProduct(id);
		}else if(type.equals("prodprice")) {
		 p=carService.searchByPrice(Long.parseLong(minp), Long.parseLong(maxp));
		}
		System.out.println(p);
		return new ModelAndView("AdminSearchResult","show", p);
		
	}
	
}
