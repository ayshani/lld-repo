package org.cricinfo.model.person;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.constants.MatchType;

import java.util.Map;

@Setter
@Getter
public class PlayerStats {
    private Map<MatchType, Stats> playerStatistics;

    @Setter
    @Getter
    private class Stats
    {
        private int matchesPlayed;
        private float overBowled;
        private float runsScored;
        private int wicketsTaken;
        private int catchesTaken;
        private int stumping;
        private float ecom;
        private float average;
    }}
