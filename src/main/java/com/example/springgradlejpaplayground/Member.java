package com.example.springgradlejpaplayground;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @ManyToOne
    private Team team;
}
