package com.tdd.junit.junittest.service;

import com.tdd.junit.junittest.model.dao.UserMapper;
import com.tdd.junit.junittest.model.dto.ActorDTO;
import com.tdd.junit.junittest.model.vo.ActorVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public ArrayList<ActorVO> findAll() {
        return userMapper.findAll();
    }

    public ActorVO findActor(String actorId) {
        return userMapper.findActor(actorId);
    }
}
