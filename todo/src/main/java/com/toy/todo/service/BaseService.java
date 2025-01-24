package com.toy.todo.service;

import java.util.List;

public interface BaseService<E> {
    public List<E> list();
    public E select(Long no);
    public E selectById(String id);
    /* 여기서 아래 5가지 메서드 타입을
       boolean으로 준 이유는 controller 에서
       true/false 여부만 체크하여 "성공/실패" 에
       따른 여부를 알려 줄 수 있도록 작성했다.
    */
    public boolean insert(E entity);
    public boolean update(E entity);
    public boolean updateById(E entity);
    public boolean delete(Long no);
    public boolean deleteById(String id);
}
