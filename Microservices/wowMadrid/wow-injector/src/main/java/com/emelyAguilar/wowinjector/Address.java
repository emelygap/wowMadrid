package com.emelyAguilar.wowinjector;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

	private Area area;
	private Disctrict district;

}
