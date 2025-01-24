package com.toy.todo.controller;

import com.toy.todo.domain.Todos;
import com.toy.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired private TodoService todoService;

    // sp-crud, 난 이 라이브러리 없고 찾아봐도 안되서 못썼음
    @GetMapping()
    public ResponseEntity<?> getAllTodo() {
        try {
            List<Todos> list = todoService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneTodo(@PathVariable String id) {
        try {
            return new ResponseEntity<>("GetOne Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createTodo(@RequestBody Todos todo) {
        try {
            return new ResponseEntity<>("GetAll Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateTodo(@RequestBody Todos todo) {
        try {
            return new ResponseEntity<>("Update Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping( {"", "/{id}"} )
    public ResponseEntity<?> destroyTodo(@PathVariable(value="", required = false) String id) {
        try {
            return new ResponseEntity<>("Delete Results", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
