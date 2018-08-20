package com.pollingapp.thebloez.payload.response;

/**
 * Created by thebloez on 04/06/18.
 */
public class UserIdentityAvailability {

    private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
