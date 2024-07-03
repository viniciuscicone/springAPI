package com.booksproject.api.controllers;

import com.booksproject.api.domain.lib.IdBook;
import com.booksproject.api.domain.lib.Lib;
import com.booksproject.api.domain.lib.LibRepository;
import com.booksproject.api.domain.lib.RequestLib;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")

public class LibController {

    @Autowired
    private LibRepository lib;

    @GetMapping
    public ResponseEntity getAllBooks() {

        var Allbooks = lib.findAll();
        return ResponseEntity.ok(Allbooks);

    }
    @PostMapping
    public ResponseEntity postBook(@RequestBody @Valid RequestLib data) {
        Lib book = new Lib(data);
        lib.save(book);
        return ResponseEntity.ok("livro cadastrado !!");
    }
    @DeleteMapping
    public ResponseEntity deteteBook(@RequestBody @Valid IdBook data) {
        lib.deleteById(data.id());
        return ResponseEntity.ok("livro deletado id : "+  data.id());
    }
    @PutMapping
    public ResponseEntity updateBook(@PathVariable String id, @RequestBody @Valid IdBook data) {
        Lib book = lib.getReferenceById(data.id());
        book.setName(data.name());
        book.setAutor(data.autor());
        lib.save(book);
        return ResponseEntity.ok("livro atualizado : " + data.id() + " - "+ data.name() + " - " + data.autor());
    }

}

