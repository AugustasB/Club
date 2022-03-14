package com.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
