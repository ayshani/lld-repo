package org.cricinfo.model.person;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.match.Team;

import java.util.Set;

@Getter
@Setter
public class PlayingMembers {
    private Team team;
    private Set<Player> players;
    private Set<Player> substitue;
}
