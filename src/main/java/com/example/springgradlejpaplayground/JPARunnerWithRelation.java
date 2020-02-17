package com.example.springgradlejpaplayground;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JPARunnerWithRelation implements ApplicationRunner {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Session session = entityManager.unwrap(Session.class);
		Member member = new Member();
		Team team = new Team();

		team.setName("team1");
		member.setUsername("Irene");
		member.addTeam(team);

		session.save(team);
	}
}
