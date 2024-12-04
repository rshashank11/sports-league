package com.team2.sportsleague;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.*;

@SpringBootApplication
public class SportsleagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsleagueApplication.class, args);
	}
}
