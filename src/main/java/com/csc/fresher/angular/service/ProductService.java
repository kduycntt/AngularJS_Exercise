package com.csc.fresher.angular.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.csc.fresher.angular.dto.Product;

@Service
public class ProductService {
	
	private static Map<Long, Product> PRODUCT_LIST = new HashMap<Long, Product>();
	private static final AtomicLong counter = new AtomicLong();
	
	static {
		Product p1 = new Product();
		p1.setId(counter.incrementAndGet());
		p1.setName("Iphone 7");
		p1.setModel("A1661 32GB Black");
		p1.setPrice(17000000);
		p1.setYear(2016);
		p1.setProducer("Apple");
		p1.setAvailable(5);
		PRODUCT_LIST.put(p1.getId(), p1);
		
		Product p2 = new Product();
		p2.setId(counter.incrementAndGet());
		p2.setName("Iphone 7 Plus");
		p2.setModel("A1660 64GB Jet Black");
		p2.setPrice(23000000);
		p2.setYear(2016);
		p2.setProducer("Apple");
		p2.setAvailable(10);
		PRODUCT_LIST.put(p2.getId(), p2);
		
		Product p3 = new Product();
		p3.setId(counter.incrementAndGet());
		p3.setName("Samsung Galaxy S7 Edge");
		p3.setModel("G935F 128Gb Black Pearl");
		p3.setPrice(20000000);
		p3.setYear(2016);
		p3.setProducer("Samsung");
		p3.setAvailable(12);
		PRODUCT_LIST.put(p3.getId(), p3);
		
		Product p4 = new Product();
		p4.setId(counter.incrementAndGet());
		p4.setName("Sony Xperia XZ");
		p4.setModel("F8332 64Gb F8332");
		p4.setPrice(12129000);
		p4.setYear(2016);
		p4.setProducer("Sony");
		p4.setAvailable(10);
		PRODUCT_LIST.put(p4.getId(), p4);
	}
	
	public List<Product> getProductList() {
		return new ArrayList<Product>(PRODUCT_LIST.values());
	}
	
	public void addProduct(Product product) {
		product.setId(counter.incrementAndGet());
		PRODUCT_LIST.put(product.getId(), product);
	}
	
	public Product getProduct(long id) {
		return PRODUCT_LIST.get(id);
	}
	
	public void updateAvailable(long id, int available) {
		Product product = PRODUCT_LIST.get(id);
		product.setAvailable(available);
	}
	
	public void increaseAvailableByOne(long id) {
		Product product = PRODUCT_LIST.get(id);
		product.setAvailable(product.getAvailable() + 1);
	}

	public void decreaseAvailableByOne(long id) {
		Product product = PRODUCT_LIST.get(id);
		product.setAvailable(product.getAvailable() - 1);
	}
	
	public boolean removeProduct(long id){
		PRODUCT_LIST.remove(id);
		return true;
	}
}
