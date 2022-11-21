package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping(value = "/public")
    public ResponseEntity<Page<Book>> getAllBook(@RequestParam Optional<String> title,
                                                 @PageableDefault(size = 12) Pageable pageable) {
        String title1 = title.orElse("");
        Page<Book> bookPage = iBookService.findByTitle(title1, pageable);
        if (!bookPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Book book = this.iBookService.findBookById(id).orElse(null);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
