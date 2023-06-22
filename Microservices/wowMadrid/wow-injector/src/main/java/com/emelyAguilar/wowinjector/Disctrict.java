package com.emelyAguilar.wowinjector;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Disctrict {
	
	private String districtName;
	
	@JsonAlias({"@id"})
	public void setDistrictName(String districtUrl) {
		this.districtName = districtUrl.substring(districtUrl.lastIndexOf("/") + 1);
	}

}
