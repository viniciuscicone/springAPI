package com.aplicacaoException.api.controller;

import com.aplicacaoException.api.domain.myTask.IdDTO;
import com.aplicacaoException.api.domain.myTask.Task;
import com.aplicacaoException.api.domain.myTask.TaskDTO;
import com.aplicacaoException.api.domain.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskRepository lib;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        when(lib.findAll()).thenReturn(Collections.emptyList());

        ResponseEntity response = taskController.getAllBooks();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    void testPostBook() {
        TaskDTO taskDTO = new TaskDTO();
        Task task = new Task(taskDTO);

        when(lib.save(any(Task.class))).thenReturn(task);

        ResponseEntity response = taskController.postBook(taskDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Task adicionada = " + task, response.getBody());
    }

    @Test
    void testDeleteBook() {
        IdDTO idDTO = new IdDTO();
        idDTO.setId(idDTO.getId());

        doNothing().when(lib).deleteById(idDTO.getId());

        ResponseEntity response = taskController.deteteBook(idDTO, null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("tarefa deletada id : " + idDTO, response.getBody());
    }

    @Test
    void testUpdateBook() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTask("Nova Tarefa");
        taskDTO.setAutor("Novo Autor");

        Task task = new Task();
        task.setTask("Tarefa Antiga");
        task.setAutor("Autor Antigo");

        when(lib.getReferenceById(anyString())).thenReturn(task);
        when(lib.save(any(Task.class))).thenReturn(task);

        ResponseEntity response = taskController.updateBook(taskDTO, null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("tarefa atualizada : " + taskDTO + " - " + taskDTO.getTask() + " - " + taskDTO.getAutor(), response.getBody());
    }
}