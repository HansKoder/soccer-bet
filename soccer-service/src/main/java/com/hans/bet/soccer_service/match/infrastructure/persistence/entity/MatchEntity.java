package com.hans.bet.soccer_service.match.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "matches")
public class MatchEntity {

    @Id
    private UUID id;

    private String local;

    private String visiting;

    private String tournament;

    @Enumerated(EnumType.STRING)
    private StatusMatchJPA status;

    public MatchEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getVisiting() {
        return visiting;
    }

    public void setVisiting(String visiting) {
        this.visiting = visiting;
    }

    public StatusMatchJPA getStatus() {
        return status;
    }

    public void setStatus(StatusMatchJPA status) {
        this.status = status;
    }


}
