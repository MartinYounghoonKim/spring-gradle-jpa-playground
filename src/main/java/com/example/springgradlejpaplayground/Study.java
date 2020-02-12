package com.example.springgradlejpaplayground;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Study {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
