package com.tdd.junit.junittest.model.dao;

import com.tdd.junit.junittest.model.vo.ActorVO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findAll() {
        // given
        List<ActorVO> actorVOList = null;

        // when
        actorVOList = userMapper.findAll();

        // then
        assertNotNull(actorVOList, "Object is Null");
    }

    @Test
    void findActor() {
        // given

        // when

        // then
    }
}
