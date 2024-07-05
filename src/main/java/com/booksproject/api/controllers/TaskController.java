package com.booksproject.api.controllers;

import com.booksproject.api.domain.lib.IdTask;
import com.booksproject.api.domain.lib.TaskClass;
import com.booksproject.api.domain.repository.TaskRepository;
import com.booksproject.api.domain.lib.RequestTask;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")

public class TaskController {

    @Autowired
    private TaskRepository lib;

    @GetMapping
    public ResponseEntity getAllBooks() {

        var Allbooks = lib.findAll();
        return ResponseEntity.ok(Allbooks);

    }
    @PostMapping
    public ResponseEntity postBook(@RequestBody @Valid RequestTask data) {
        TaskClass book = new TaskClass(data);
        lib.save(book);
        return ResponseEntity.ok("tarefa cadastrada !!");
    }
    @DeleteMapping
    public ResponseEntity deteteBook(@RequestBody @Valid IdTask data) {
        lib.deleteById(data.id());
        return ResponseEntity.ok("tarefa deletada id : "+  data.id());
    }
    @PutMapping
    public ResponseEntity updateBook(@RequestBody @Valid IdTask data) {
      /*  @PathVariable String id        nos parametros*/
        TaskClass book = lib.getReferenceById(data.id());
        book.setTask(data.task());
        book.setAutor(data.autor());
        lib.save(book);
        return ResponseEntity.ok("tarefa atualizada : " + data.id() + " - "+ data.task() + " - " + data.autor());
    }

}

