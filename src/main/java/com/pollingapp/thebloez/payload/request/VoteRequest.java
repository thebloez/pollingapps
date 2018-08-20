package com.pollingapp.thebloez.payload.request;

import javax.validation.constraints.NotNull;

/**
 * Created by thebloez on 04/06/18.
 */
public class VoteRequest {

    @NotNull
    private Long choiceId;

    public Long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Long choiceId) {
        this.choiceId = choiceId;
    }
}
