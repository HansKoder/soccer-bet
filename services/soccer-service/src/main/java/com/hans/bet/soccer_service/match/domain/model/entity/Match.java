package com.hans.bet.soccer_service.match.domain.model.entity;

import com.hans.bet.soccer_service.shared.domain.model.entity.AggregateRoot;
import com.hans.bet.soccer_service.match.domain.model.exception.SoccerDomainException;
import com.hans.bet.soccer_service.match.domain.model.valueobject.MatchId;
import com.hans.bet.soccer_service.match.domain.model.valueobject.StatusMatch;
import com.hans.bet.soccer_service.match.domain.model.valueobject.Team;

import java.util.Objects;
import java.util.UUID;

public class Match extends AggregateRoot<MatchId> {

    private Team local;
    private Team visiting;
    private StatusMatch statusMatch;
    private String tournament;

    private Match() {
    }

    private static void teamMustBeUnique (String local, String visiting) {
        if (local.equalsIgnoreCase(visiting))
            throw new SoccerDomainException("The visiting team must be different to local team");
    }

    public static Match schedule (String local, String visiting, String tournament) {
        teamMustBeUnique(local, visiting);

        Match match = new Match();
        match.setId(new MatchId(UUID.randomUUID()));
        match.local = new Team(local, tournament);
        match.visiting = new Team(visiting, tournament);
        match.tournament = tournament;
        match.statusMatch = StatusMatch.SCHEDULED;

        return match;
    }

    public void start () {
        if (!statusMatch.equals(StatusMatch.SCHEDULED))
            throw new SoccerDomainException("Status must be scheduled");

        statusMatch = StatusMatch.STARTED;
    }

    public void finish () {
        if (!statusMatch.equals(StatusMatch.STARTED))
            throw new SoccerDomainException("Status must be started");

        statusMatch = StatusMatch.FINISHED;
    }

    public Team getLocal() {
        return local;
    }

    public StatusMatch getStatusMatch() {
        return statusMatch;
    }

    public Team getVisiting() {
        return visiting;
    }

    public String getTournament() {
        return tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Match match = (Match) o;
        return Objects.equals(local, match.local) && Objects.equals(visiting, match.visiting) && statusMatch == match.statusMatch && Objects.equals(tournament, match.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), local, visiting, statusMatch, tournament);
    }

    @Override
    public String toString() {
        return "Match{" +
                "local=" + local +
                ", visiting=" + visiting +
                ", statusMatch=" + statusMatch +
                ", tournament='" + tournament + '\'' +
                '}';
    }

    public static final class Builder {
        private Team local;
        private Team visiting;
        private StatusMatch statusMatch;
        private MatchId id;
        private String tournament;

        private Builder() {
        }

        public static Builder aMatch() {
            return new Builder();
        }

        public Builder local(Team local) {
            this.local = local;
            return this;
        }

        public Builder visiting(Team visiting) {
            this.visiting = visiting;
            return this;
        }

        public Builder statusMatch(StatusMatch statusMatch) {
            this.statusMatch = statusMatch;
            return this;
        }

        public Builder id(MatchId id) {
            this.id = id;
            return this;
        }

        public Builder tournament(String tournament) {
            this.tournament = tournament;
            return this;
        }

        public Match build() {
            Match match = new Match();
            match.setId(id);
            match.visiting = this.visiting;
            match.local = this.local;
            match.statusMatch = this.statusMatch;
            match.tournament = this.tournament;

            return match;
        }
    }
}
