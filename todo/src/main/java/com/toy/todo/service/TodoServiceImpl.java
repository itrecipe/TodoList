package com.toy.todo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.toy.todo.domain.Todos;
import com.toy.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired private TodoMapper todoMapper;

    @Override
    public List<Todos> list() {
        return todoMapper.list();
    }

    @Override
    public Todos select(Long no) {
        return todoMapper.select(no);
    }

    @Override
    public Todos selectById(String id) {
        return todoMapper.selectById(id);
    }

    @Override
    public boolean insert(Todos entity) {
        // true & false 여부만 체크하면 되니까 아래와 같이 작성 나머지도 동일하다.
        return todoMapper.insert(entity) > 0;
    }

    @Override
    public boolean update(Todos entity) {
        return todoMapper.update(entity) > 0;
    }

    @Override
    public boolean updateById(Todos entity) {
        return todoMapper.updateById(entity) > 0;
    }

    @Override
    public boolean delete(Long no) {
        return todoMapper.delete(no) > 0;
    }

    @Override
    public boolean deleteById(String id) {
        return todoMapper.deleteById(id) > 0;
    }

    @Override
    public PageInfo<Todos> list(int page, int size) {
        // PageHelper.startPage( 현재 페이지, 페이지별 게시글 수);
        PageHelper.startPage(page, size);

        // 리스트 조회
        List<Todos> list = todoMapper.list();
        PageInfo<Todos> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
