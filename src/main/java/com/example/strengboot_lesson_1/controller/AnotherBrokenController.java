package com.example.strengboot_lesson_1.controller;

import com.example.strengboot_lesson_1.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/another_error")
public class AnotherBrokenController {

    @GetMapping("/iae")
    public Person throwExceptionIne() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> reHandler(RuntimeException e) {
//        return new ResponseEntity<>("RuntimeException in throwExceptionIne method", HttpStatus.I_AM_A_TEAPOT);
//    }
}
