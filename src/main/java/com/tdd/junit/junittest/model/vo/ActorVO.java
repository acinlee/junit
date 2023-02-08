package com.tdd.junit.junittest.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ActorVO {
    String actorId;
    String firstName;
    String lastName;
    String lastUpdate;

    @Builder
    public ActorVO(String actorId, String firstName, String lastName, String lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
}
