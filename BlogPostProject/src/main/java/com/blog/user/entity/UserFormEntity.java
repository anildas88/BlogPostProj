package com.blog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="REG_FORM")
public class UserFormEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SLNO")
	private int slNo;
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PWD")
	private String password;

}
