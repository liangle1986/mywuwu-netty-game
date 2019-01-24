package com.mywuwu.mysql.service.Impl;

import com.mywuwu.mysql.entity.Test;
import com.mywuwu.mysql.mapper.TestMapper;
import com.mywuwu.mysql.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/24 11:45
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> getFindAll(){
      return testMapper.selectAll();
    }
}
