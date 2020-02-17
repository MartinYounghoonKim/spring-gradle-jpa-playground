package com.example.springgradlejpaplayground;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		session.save(team);

		member.setUsername("Martin");
		member.setTeam(team);
		team.getMembers().add(member);

		System.out.println();

		session.save(team);
		session.save(member);

	}
}
