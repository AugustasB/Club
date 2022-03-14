package com.warehouse.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JacksonException;
import com.warehouse.entities.Item;
import com.warehouse.exceptions.ErrorResponse;
import com.warehouse.exceptions.ItemException;
import com.warehouse.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService is;
	
	@ExceptionHandler(value = {JacksonException.class})
	public ResponseEntity<ErrorResponse> invalidData() {
		System.out.println("error caught");
		return new ResponseEntity<>(new ErrorResponse("Wrong input type", "", 400), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {ItemException.class})
	public ResponseEntity<ErrorResponse> itemException(ItemException e){
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "" ,e.getCode()), HttpStatus.valueOf(e.getCode()));
	}
	
	
	
	@CrossOrigin
	@GetMapping("/")
	public List<Item> index() {
		return is.getItems();
	}
	
	@CrossOrigin
	@PostMapping("/")
	public Item add(@RequestBody Item i) {
		return is.saveItem(i);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Item get(@PathVariable Integer id) {		
		Item i = is.getItem(id);
		if (i == null) {
			throw new ItemException("Item with "+id+" not found", 404);
		}
		return i;
	}
	
	@CrossOrigin
	@PatchMapping("/{id}")
	public Item update(@PathVariable Integer id, @RequestBody Item i) {		
		if (i.getPrice() <= 0  || i.getQuantity() <= 0) {
			throw new ItemException("price or quantity cant be below 1", 400);
		}
		return is.updateItem(i);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable Integer id) {		
		is.deleteItem(id);
		return true;
	}
	
	

}
