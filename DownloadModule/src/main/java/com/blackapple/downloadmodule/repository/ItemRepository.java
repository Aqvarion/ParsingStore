package com.blackapple.downloadmodule.repository;

import com.blackapple.downloadmodule.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Optional<Item> findByTitle(String title);
}
