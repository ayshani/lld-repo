package org.cricinfo.model.match;

import org.cricinfo.model.constants.MatchResult;
import org.cricinfo.model.person.Commentator;
import org.cricinfo.model.person.Referee;
import org.cricinfo.model.person.Scorer;
import org.cricinfo.model.person.Umpire;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Match {
    private String matchId;
    private Tournament tournament;
    private final TeamsBetween teamsBetween;
    private String venue;
    private Toss toss;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Umpire> umpires;
    private Team winner;
    private Team lost;
    private MatchResult matchResult;
    private Map<Team, Map<Integer,Innings>> innings;
    private List<Commentator> commentators;
    private List<Scorer> scorers;
    private List<Referee> referees;

    public Match(TeamsBetween teamsBetween) {
        this.matchId = UUID.randomUUID().toString();
        this.teamsBetween = teamsBetween;
        umpires = new ArrayList<>();
        innings = new HashMap<>();
        commentators = new ArrayList<>();
        scorers = new ArrayList<>();
        referees = new ArrayList<>();
    }
}
