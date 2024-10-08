package com.example.cashcard.repository;

import com.example.cashcard.model.CashCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CrudRepository is an interface supplied by Spring Data. Along with Spring Boot, this will generate CRUD methods
 * automatically.
 */
public interface CashCardRepository extends CrudRepository<CashCard, Long>, PagingAndSortingRepository<CashCard, Long> {
}
