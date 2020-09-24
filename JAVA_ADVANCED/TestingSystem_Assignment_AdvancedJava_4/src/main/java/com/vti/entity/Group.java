package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "`Group`", catalog = "TestingSystem")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String name;
	
	@Column(name = "CreateDate")
	@Temporal (TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Group() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", createDate=" + createDate + "]";
	}
}
