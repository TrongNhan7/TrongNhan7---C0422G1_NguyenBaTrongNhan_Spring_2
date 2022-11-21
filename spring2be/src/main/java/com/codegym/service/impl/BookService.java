package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Optional<Book> findBookById(Long id) {
        return this.iBookRepository.findById(id);
    }

    @Override
    public Page<Book> findByTitle(String tittle, Pageable pageable) {
        return iBookRepository.findByTitleContaining(tittle, pageable);
    }
}
