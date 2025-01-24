package com.toy.todo.service;

import com.toy.todo.domain.Todos;
import org.springframework.stereotype.Service;

/* 이미 BaseService<Todos>에서 공통적인 crud 기능에 대한
   서비스 인터페이스를 상속 받았기 때문에 더 이상 적을 것은 없다.
   (단, 추가 기능이 있다면 그 부분만 작성해주면 된다.)
*/
@Service
public interface TodoService extends BaseService<Todos> {
}
