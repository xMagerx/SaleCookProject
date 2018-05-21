package com.hipasserby.request;

public class DeleteUserRequest {
	
	private Integer id;
	
	public DeleteUserRequest(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DeleteUserRequest{" +
				"id=" + id +
				'}';
	}
}
