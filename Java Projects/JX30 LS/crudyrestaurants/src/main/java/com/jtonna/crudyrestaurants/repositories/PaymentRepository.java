package com.jtonna.crudyrestaurants.repositories;

import com.jtonna.crudyrestaurants.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository
        extends CrudRepository<Payment, Long> // We extend CrudRepository from maven & it needs to know the Model we are working with and the Primary Key datatype.
{
}
