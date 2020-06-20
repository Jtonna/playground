package com.jtonna.crudyrestaurants.repositories;

import com.jtonna.crudyrestaurants.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository
        extends CrudRepository<Menu, Long> // We extend CrudRepository from maven & it needs to know the Model we are working with and the Primary Key datatype.
{

}
