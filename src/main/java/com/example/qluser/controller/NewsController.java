package com.example.qluser.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.qluser.entity.News;
import com.example.qluser.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping("/index/news")
	public String listNews(Model model) {
		model.addAttribute("listNews", newsService.findAll());
		return "pages/listNews";
	}
	
	@GetMapping("/news/create")
	public String CreateNews(Model model) {
		int max = newsService.maxId() + 1;
		model.addAttribute("news", new News(max));
		return "pages/addNews";
	}
	
	@GetMapping("/news/view/{id}")
	public String viewNews(@PathVariable int id,Model model) {
		model.addAttribute("news", newsService.findOne(id));
		return "pages/infoNews";
	}
	
	@PostMapping("/news/save")
	public String saveNews(@Valid News news, BindingResult bindingResult, RedirectAttributes redirect) {
		if(bindingResult.hasErrors()) {
			return "pages/addNews";
		}
		newsService.save(news);
		redirect.addFlashAttribute("success", "Add news success!");
		return "redirect:/index/news";
	}
	
	@GetMapping("/news/edit/{id}")
	public String editNews(@PathVariable int id,Model model) {
		model.addAttribute("news", newsService.findOne(id));
		return "pages/addNews";
	}
	
	@GetMapping("/news/delete/{id}")
	public String deleteNews(@PathVariable int id, RedirectAttributes redirect) {
		newsService.delete(id);
		redirect.addFlashAttribute("success", "Delete news success!");
		return "redirect:/index/news";
	}
	
	@GetMapping("/news/search")
	public String searchNews(@RequestParam String title,Model model) {
		if (title.equals("")) {
			return "redirect:/index/news";
		}
		model.addAttribute("listNews", newsService.search(title));
		return "pages/listNews";
	}
}
