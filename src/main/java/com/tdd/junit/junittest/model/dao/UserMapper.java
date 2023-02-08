package com.tdd.junit.junittest.model.dao;

import com.tdd.junit.junittest.model.vo.ActorVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface UserMapper {

    ArrayList<ActorVO> findAll();

    ActorVO findActor(String actorId);
}
