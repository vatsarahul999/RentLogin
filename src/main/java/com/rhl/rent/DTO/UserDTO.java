package com.rhl.rent.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO {
	
	private String userName;
	private String pwd;
	private String role;
	private String passwordConfirm;

}
