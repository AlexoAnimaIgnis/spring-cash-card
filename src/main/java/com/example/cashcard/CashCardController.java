package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * annotation that marks findById as a handler method, that will handle
     * requests that match /cashcards/{requestedID}
     */
    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById() {
        CashCard cashCard = new CashCard(99L, 123.45);
        return ResponseEntity.ok(cashCard);
    }
}
