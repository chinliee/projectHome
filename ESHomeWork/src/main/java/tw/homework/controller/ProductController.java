package tw.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.homework.model.dto.product.ProductFindDto;
import tw.homework.model.dto.product.ProductInertDto;
import tw.homework.model.entity.Product;
import tw.homework.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/find")
	public List<ProductFindDto> findAll(){
		
		return productService.findAll();
	}
	
	@PostMapping("/product/insert")
	public Product Insert(@RequestBody ProductInertDto dto) {
		
		return productService.productInsert(dto);	
	}
	
	@PostMapping("/product/findCustomer")
	public List<ProductFindDto> findAllCustomer(){
		
		return productService.findAllCustomer();
	}
}
