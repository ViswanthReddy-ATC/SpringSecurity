
package com.viswa.springsecdemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.viswa.springsecdemo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Optional<Customer> findByEmail(String email);
}
