package com.example.demo.bdd.runner;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DemoprojectApplication;

import io.cucumber.spring.CucumberContextConfiguration;


	@CucumberContextConfiguration
	@SpringBootTest(classes=DemoprojectApplication.class)
	public class CucumberConfig {
	}

