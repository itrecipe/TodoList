package com.toy.todo.mapper;

import com.toy.todo.domain.Todos;
import org.apache.ibatis.annotations.Mapper;

/* 여기서도 BaseMapper<Todos> 메퍼 인터페이스를 이미 상속 받고 있기 때문에
   추가 기능을 정의할게 아니면 더 이상 적을 것은 없다.
*/

@Mapper
public interface TodoMapper extends BaseMapper<Todos> {

}
