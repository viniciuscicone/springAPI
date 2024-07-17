package com.aplicacaoException.api.controller;

import com.aplicacaoException.api.domain.myTask.idDTO;
import com.aplicacaoException.api.domain.myTask.Task;
import com.aplicacaoException.api.domain.myTask.TaskDTO;
import com.aplicacaoException.api.domain.myTask.request.TaskRequest;
import com.aplicacaoException.api.domain.repository.TaskRepository;
import jakarta.validation.Valid;
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
    public ResponseEntity postBook(@RequestBody @Valid TaskRequest task) {

      /*  if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
*/
        /*lib.save(book);*/
        return ResponseEntity.ok("Cliente é valido => " + task);
    }
    @DeleteMapping
    public ResponseEntity deteteBook(@RequestBody @Valid idDTO data, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }

        lib.deleteById(data.id());
        return ResponseEntity.ok("tarefa deletada id : "+  data.id());
    }
    @PutMapping
    public ResponseEntity updateBook(@RequestBody @Valid TaskDTO data, @RequestBody @Valid idDTO dataId, Errors errors) {
        /*  @PathVariable String id        nos parametros*/

        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }

        Task book = lib.getReferenceById(dataId.id());
        book.setTask(data.task());
        book.setAutor(data.autor());
        lib.save(book);
        return ResponseEntity.ok("tarefa atualizada : " + dataId.id() + " - "+ data.task() + " - " + data.autor());
    }

}



