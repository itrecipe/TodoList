package com.toy.todo.mapper;

import java.util.List;

/* 공통적으로 사용할 메소드를 정의한 메퍼
   TodoMapper.xml 에서 작성한 id와 연결되는
   메서드를 제네릭 기법으로 작성
   (todos 객체를 상속 받아 사용할 예정)
*/

public interface BaseMapper<E> {
    public List<E> list();
    public E select(Long no);
    public E selectById(String id);
    public int insert(E entity);
    public int update(E entity);
    public int updateById(E entity);
    public int delete(Long no);
    public int deleteById(String id);
}
