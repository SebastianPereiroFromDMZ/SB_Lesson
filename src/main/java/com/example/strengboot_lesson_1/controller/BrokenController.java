package com.example.strengboot_lesson_1.controller;

import com.example.strengboot_lesson_1.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/error")
public class BrokenController {

    @GetMapping("/error")
    public String error() {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        } catch (RuntimeException e) {
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("/iae")
    public Person throwExceptionIne() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(IllegalArgumentException.class)//такие хэндлеры они привязанны к конкретному классу, тоесть другой контроллер например их видеть не будет,
//    //для того чтобы обработчик обрабатывал все контроллеры надо создать отдельный класс обработчиков у нас это  ExceptionHandlerAdvice
//    public ResponseEntity<String> iaeHandler(IllegalArgumentException e) {
//        //здесь может быть какая то логика например закрытие файлов, ресурсов
//        return new ResponseEntity<>("IllegalArgumentException in throwExceptionIne method", HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> reHandler(RuntimeException e) {
//        return new ResponseEntity<>("RuntimeException in throwExceptionIne method", HttpStatus.I_AM_A_TEAPOT);
//    }
}
