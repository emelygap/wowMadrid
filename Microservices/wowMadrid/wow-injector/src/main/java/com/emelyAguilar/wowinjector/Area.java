package com.emelyAguilar.wowinjector;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Area {
	@JsonAlias({"street-address"})
	private String streetAddress;
	
	@JsonAlias({"postal-code"})
	private String postalCode;

}
