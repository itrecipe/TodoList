package com.toy.todo.controller;

import com.github.pagehelper.PageInfo;
import com.toy.todo.domain.Pagination;
import com.toy.todo.domain.Todos;
import com.toy.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /* sp-crud : 해당 라이브러리를 갖다 쓰려고 검색해봤으나 못 찾음,
       그리고 사용방법을 잘 모르겠음(어떻게 쓰는건지 나중에 다시 확인해볼것)
     */
    @GetMapping()
    public ResponseEntity<?> getAllTodo(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size
    ) {
        try {
            PageInfo<Todos> pageInfo = todoService.list(page, size);
            Pagination pagination = new Pagination(); // 페이지네이션 객체 생성
            pagination.setPage(page);
            pagination.setSize(size);
            pagination.setTotal(pageInfo.getTotal());

            List<Todos> list = pageInfo.getList();
            Map<String, Object> response = new HashMap<>();
            response.put("list", list);
            response.put("pagination", pagination);

            /* return new ResponseEntity<>(list, HttpStatus.OK);
               트러블 슈팅 : 반환타입을 response로 넘겨줘야 하는데 list를 반환하고 있어서
               페이지 네이션 정보가 스웨거 UI로 테스트가 안됬었던 문제를 해결 했다.
            */
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneTodo(@PathVariable("id") String id) {
        try {
            Todos todo = todoService.selectById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createTodo(@RequestBody Todos todo) {
        try {
            boolean result = todoService.insert(todo);
            if(result)
                return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateTodo(@RequestBody Todos todo) {
        try {
            boolean result = todoService.updateById(todo);
            if(result)
                return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
            else
                return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> destroyTodo(@PathVariable("id") String id) {
        try {
            boolean result = todoService.deleteById(id);
            if(result)
                return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
            else
                return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}