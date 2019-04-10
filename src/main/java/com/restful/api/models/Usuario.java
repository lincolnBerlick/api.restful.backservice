package com.restful.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		
@Table(name="table_usuarios")
public class Usuario  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private long user_id;
	
	
	@Column(name = "user_name")
	private String username;
	
	

	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_senha")
	private String user_Senha;
	
	private int user_type;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmaill(String email) {
		this.email = email;
	}

	public String getUser_Senha() {
		return user_Senha;
	}

	public void setUser_Senha(String user_Senha) {
		this.user_Senha = user_Senha;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
