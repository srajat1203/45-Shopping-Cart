package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the REVS database table.
 * 
 */
@Entity
@Table(name="REVS", schema="TESTDB")
@NamedQuery(name="Rev.findAll", query="SELECT r FROM Rev r")
public class Rev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "RevSeq", sequenceName = "REVS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "RevSeq")
	private long id;

	private String comt;

	private int pid;

	private String rdate;

	private int stars;

	private String uemail;

	public Rev() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComt() {
		return this.comt;
	}

	public void setComt(String comt) {
		this.comt = comt;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid2) {
		this.pid = pid2;
	}

	public String getRdate() {
		return this.rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

}