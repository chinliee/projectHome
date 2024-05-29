package tw.homework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.homework.model.dto.product.ProductFindDto;
import tw.homework.model.dto.product.ProductInertDto;
import tw.homework.model.entity.Product;
import tw.homework.model.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductFindDto> findAll(){
		
		List<Product> productlList = productRepository.findAll();
		
		List<ProductFindDto> productFindDtolList = new ArrayList<>();
		for(Product product : productlList) {
		
		ProductFindDto productFindDto = new ProductFindDto(); 
		
		productFindDto.setProductId(product.getProductId());
		productFindDto.setProductName(product.getProductName());
		productFindDto.setPrice(product.getPrice());
		productFindDto.setQuantity(product.getQuantity());
		
		productFindDtolList.add(productFindDto);
		
		}	
		return productFindDtolList;
		
	}
	
	public Product productInsert(ProductInertDto dto) {
		
		Product product = new Product();
		
		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		
		return productRepository.save(product);
		
	}
	
public List<ProductFindDto> findAllCustomer(){
		
		List<Product> productlList = productRepository.findAll();
		
		List<ProductFindDto> productFindDtolList = new ArrayList<>();
		for(Product product : productlList) {
		
		
		if(product.getQuantity() >= 1) {
			ProductFindDto productFindDto = new ProductFindDto(); 
			productFindDto.setProductId(product.getProductId());
			productFindDto.setProductName(product.getProductName());
			productFindDto.setPrice(product.getPrice());
			productFindDto.setQuantity(product.getQuantity());
			
			productFindDtolList.add(productFindDto);			
		}
		
		
		}	
		return productFindDtolList;
		
	}
	
	
	
	
	
}
