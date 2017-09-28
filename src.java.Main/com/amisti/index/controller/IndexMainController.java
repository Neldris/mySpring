package com.amisti.index.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amisti.pojo.user.Box;
import com.amisti.pojo.user.Pop;
import com.amisti.pojo.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;


@Controller
public class IndexMainController {

	@SessionScope

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Pop getUser() {
		Pop p = Pop.getInstance();
		User u = new User(78, "Home boy", new Date(System.currentTimeMillis()));
		List<User> l = new ArrayList<>();
		l.add(u);
		p.setUserMoster(l);
		p.setName("Richars King");
		return p;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Pop getAll(@RequestBody User u, HttpServletRequest req, HttpServletResponse resp) {

		List<User> l = new ArrayList<>();
		l.add(u);
		Pop p = Pop.getInstance();
		p.setUserMoster(l);

		return p;

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("bo") Dog b,HttpServletRequest req, HttpServletResponse resp, Model model) {
		Pop p = Pop.getInstance();
		
		Map<String,String> maps= System.getenv();
		StringBuilder build = new StringBuilder();
		for(Map.Entry<String, String> m: maps.entrySet()){
			build.append("key: "+m.getKey()+" Value: " +m.getValue()+"<br/>");
		}
		model.addAttribute("home", build.toString());
		ModelAndView mm = new ModelAndView("home");
		mm.addObject(model);
		HttpSession session = req.getSession();
		
		session.setAttribute("r", p);
		return mm;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET, produces="application/json")
	public ModelAndView contact(HttpServletRequest req, HttpServletResponse resp, Model model) {
		Pop p = Pop.getInstance();
		model.addAttribute("contact", p);
		ModelAndView mm = new ModelAndView("contact");
		mm.addObject(model);
		Pop v = (Pop) req.getSession().getAttribute("r");
		if (v != null) {
			System.out.println(v.getName());
			System.out.println("data:{");
			v.getUserMoster().forEach(x -> {

				System.out.println("{'Name':" + x.getFullName());
				System.out.println("'Age':" + x.getAge());
				System.out.println("'Date':" + x.getDate().toString());
				System.out.println("},");
			});
			System.out.println("}");
		}
		return mm;
	}

	@RequestMapping(value = "/box", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Box getBox() {
		Box u = new Box();
		u.setId(9000);
		u.setAddress("The Cathedral road");
		u.setName("Richard King Here king");
		return u;
	}
	
	@RequestMapping(value = "/hello", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json")
	public @ResponseBody Dog get(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		Dog b = new Dog();
		b.setId(Integer.parseInt(request.getParameter("id")));
		b.setAddress((String) request.getParameter("address"));
		b.setName( (String)request.getParameter("name"));
		b.setFileName(file.getOriginalFilename());
		String date = (String)request.getParameter("date");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm",Locale.UK);

		Date d=null;
		try {
			d = (Date) format.parse(date);
			b.setDate(d);
			System.out.println(d);
		} catch (ParseException e) {
			b.setDate(new Date(System.currentTimeMillis()));
			
		}
		
		
		if(file != null && !file.isEmpty())
			file.transferTo(new File("/home/richie/"+file.getOriginalFilename()));
			System.out.println(file.getOriginalFilename()+" "+file.getSize());
		return b;
	}
	
	@RequestMapping(value = "/ajax", method = {RequestMethod.POST,RequestMethod.GET},
			produces="application/json", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Dog ajax(Model m,HttpServletRequest request){
		Dog b = new Dog();
		b.setId(Integer.parseInt(request.getParameter("id")));
		b.setAddress((String) request.getParameter("address"));
		b.setName( (String)request.getParameter("name"));
		System.out.println(request.getParameter("name"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}

@XmlRootElement
class Dog implements Serializable{
	public Dog(){}
	private int id;
	private String name;
	private String address;
	private Date date;
	private String fileName;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(timezone="GMT",pattern="yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		if(date == null)  return new Date(System.currentTimeMillis());
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}



