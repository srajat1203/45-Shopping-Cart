package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS", schema="TESTDB")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "UserSeq", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "UserSeq")
	private long id;

	private double credit;

	private String email;

	private String name;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}