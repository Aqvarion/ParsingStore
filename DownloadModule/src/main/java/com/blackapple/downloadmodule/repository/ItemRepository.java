package com.blackapple.downloadmodule.repository;

import com.blackapple.downloadmodule.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
}
