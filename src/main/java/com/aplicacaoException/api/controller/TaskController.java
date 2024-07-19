package com.aplicacaoException.api.controller;

import com.aplicacaoException.api.domain.myTask.IdDTO;
import com.aplicacaoException.api.domain.myTask.Task;
import com.aplicacaoException.api.domain.myTask.TaskDTO;
import com.aplicacaoException.api.domain.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity postBook(@RequestBody @Valid TaskDTO task) {
        Task taskNew = new Task(task);
        /*lib.save(taskNew);*/
        return ResponseEntity.ok("Task adicionada = " + taskNew);
    }
    @DeleteMapping
    public ResponseEntity deteteBook(@RequestBody @Valid IdDTO data, Errors errors) {

        lib.deleteById(data.getId());
        return ResponseEntity.ok("tarefa deletada id : "+  data);
    }
    @PutMapping
    public ResponseEntity updateBook(@RequestBody @Valid TaskDTO data, Errors errors) {
        /*  @PathVariable String id        nos parametros*/

        Task task = lib.getReferenceById(data.getTask());
        task.setTask(data.getTask());
        task.setAutor(data.getAutor());
        lib.save(task);
        return ResponseEntity.ok("tarefa atualizada : " + data + " - "+ data.getTask() + " - " + data.getAutor());
    }
}



