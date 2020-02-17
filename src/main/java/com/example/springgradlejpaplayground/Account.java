package com.example.springgradlejpaplayground;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String username;

	// @Column 이 생략되어있다고 생각해도 된다.
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Transient // 컬럼으로 맵핑되지 않는다.
	private Boolean no;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "home_street"))
	})
	private Address address;
}
