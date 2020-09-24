package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	private short groupId;

	@Column(name = "AccountID")
	private short accountId;

	public GroupAccountKey() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public short getAccountId() {
		return accountId;
	}

	public void setAccountId(short accountId) {
		this.accountId = accountId;
	}
}
