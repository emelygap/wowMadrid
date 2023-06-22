package com.emelyAguilar.wowinjector;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MadridResponse {
	@JsonProperty("@graph")
	private List<Event> events;
}
