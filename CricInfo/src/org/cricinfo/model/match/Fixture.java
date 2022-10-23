package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Fixture {

    private String tournament;
    private TeamsBetween teamsBetween;
    private Stadium toBePlayed;
    private LocalDateTime matchStartTime;
}
