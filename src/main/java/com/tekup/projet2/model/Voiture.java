package com.tekup.projet2.model;

import io.swagger.annotations.ApiModelProperty;

public class Voiture {
	@ApiModelProperty(notes = "Name of the Voiture", name = "name", required = true)
	private String name;
	@ApiModelProperty(notes = "Standard of the Voiture", name = "standard", required = true)
	private int standard;
	@ApiModelProperty(notes = "Address of the Voiture", name = "address", required = true)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
