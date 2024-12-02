package com.team2.sportsleague;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.*;

@SpringBootApplication
public class SportsleagueApplication {
	private static PasswordEncoder passwordEncoder;

	@Autowired
	public SportsleagueApplication(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}


	public static void main(String[] args) {
		SpringApplication.run(SportsleagueApplication.class, args);
//		printEncodedPassword("johnDoe@5");
	}
//
//	public static void printEncodedPassword(String rawPassword) {
//		String encodedPassword = passwordEncoder.encode(rawPassword);
//		System.out.println("Raw Password: " + rawPassword);
//		System.out.println("Encoded Password: " + encodedPassword);
//	}
}
