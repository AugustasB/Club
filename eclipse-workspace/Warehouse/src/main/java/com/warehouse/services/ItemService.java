package com.warehouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.entities.Item;
import com.warehouse.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	public List<Item> getItems(){
		return ir.findAll();
	}
	
	public Item saveItem(Item item) {
		return ir.save(item);
	}
	
	public Item getItem(Integer id) {
		return ir.findById(id).orElse(null);
	}
	
	public Item updateItem(Item i) {
		Item old = this.getItem(i.getId());
		old.setName(i.getName());
		old.setDescription(i.getDescription());
		old.setQuantity(i.getQuantity());
		old.setPrice(i.getPrice());
		old.setPicture(i.getPicture());
		ir.save(old);
		return old;
	}
	
	public void deleteItem(Integer id) {
		ir.deleteById(id);
	}
}
