package com.example.springgradlejpaplayground;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @ManyToOne
    private Team team;

    public void addTeam (Team team) {
        if (this.team != null) {
            // 기존 맺어져 있는 관계를 제거해야 한다.
            this.team.getMembers().remove(this);
        }
        this.setTeam(team);
        team.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
