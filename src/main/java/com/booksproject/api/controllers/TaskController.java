package com.booksproject.api.controllers;

import com.booksproject.api.domain.lib.IdTask;
import com.booksproject.api.domain.lib.TaskClass;
import com.booksproject.api.domain.repository.TaskRepository;
import com.booksproject.api.domain.lib.RequestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
    public ResponseEntity postBook(@RequestBody RequestTask data, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }

        TaskClass book = new TaskClass(data);
        /*lib.save(book);*/
        return ResponseEntity.status(200).body("tarefa cadastrada !!");
    }
    @DeleteMapping
    public ResponseEntity deteteBook(@RequestBody IdTask data, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }

        lib.deleteById(data.id());
        return ResponseEntity.ok("tarefa deletada id : "+  data.id());
    }
    @PutMapping
    public ResponseEntity updateBook(@RequestBody IdTask data, Errors errors) {
      /*  @PathVariable String id        nos parametros*/

        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }

        TaskClass book = lib.getReferenceById(data.id());
        book.setTask(data.task());
        book.setAutor(data.autor());
        lib.save(book);
        return ResponseEntity.ok("tarefa atualizada : " + data.id() + " - "+ data.task() + " - " + data.autor());
    }

}

