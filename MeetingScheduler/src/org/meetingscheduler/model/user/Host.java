package org.meetingscheduler.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Host extends User {

    public Host( String name, String email) {
        super(UUID.randomUUID().toString(), name, email);
    }

}
