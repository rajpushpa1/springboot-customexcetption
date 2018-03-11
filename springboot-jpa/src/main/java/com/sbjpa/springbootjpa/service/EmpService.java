package com.sbjpa.springbootjpa.service;

import org.springframework.stereotype.Service;

@Service
public class EmpService {

	public String findByName(String name) {

		if (name.endsWith("raj")) {

			return "matached";
		}
		return null;
	}

}
