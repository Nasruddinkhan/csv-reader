package com.mypractice.csvreader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "msis")
public class Msis {
	
	@Id
	@Column(name = "MSISDN")
	private String msisdn;
	
	@Column(name = "SIM_TYPE")
	private String simType;
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "ID_NUMBER")
	private String idNumber;
}
