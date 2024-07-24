package com.stream;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	// user의 name과 order list
	private String name;
	private List<Order> orders;

}
