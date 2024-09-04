package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * this annotation tells Spring that this class is a component of type RestController that
 * will handle http requests
 */
@RestController
/**
 * this annotation is a companion to restcontroller to indicate which address/request
 * can have access to this controller
 */
@RequestMapping("/cashcards")
public class CashCardController {

    private final CashCardRepository cashCardRepository;

    /**
     * @TODO: Understand the different concepts of injection
     * construction injection
     * @param cashCardRepository
     */
    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    /**
     * annotation that marks findById as a handler method, that will handle
     * requests that match /cashcards/{requestedID}
     */
    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(
            /**
             * PathVariable makes Spring Web aware of the requestedID supplied in the HTTP request
             */
            @PathVariable Long requestedId) {

        Optional<CashCard> cashCard = cashCardRepository.findById(requestedId);
        return cashCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
