package com.example.cashcard;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository is an interface supplied by Spring Data. Along with Spring Boot, this will generate CRUD methods
 * automatically.
 */
public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
