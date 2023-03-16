package com.marketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDto {
	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
}
