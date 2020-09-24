package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.PositionNameConvert;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "PositionName", length = 50, nullable = false, unique = true)
	@Convert(converter =  PositionNameConvert.class)
	private PositionName positionName;

	public Position() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", positionName=" + positionName + "]";
	}
}
