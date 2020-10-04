package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ProductDao;
import com.model.Product;

@Controller
public class MainController 
{

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) 
	{
		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);
		
		return "index";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model m) 
	{
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) 
	{
		System.out.println(product);
		this.productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping(value = "/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, Model m)
	{
		Product product = this.productDao.getProduct(productId);
		m.addAttribute("product", product);
		m.addAttribute("title", "Update Product");
		return "update_form";
	}
	
	@RequestMapping(value = "/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

}
