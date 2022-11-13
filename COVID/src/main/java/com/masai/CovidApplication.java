package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masai.repo.MemberRepo;

@SpringBootApplication
public class CovidApplication {

	static MemberRepo mr;
	
    public static void main(String[] args) {
        SpringApplication.run(CovidApplication.class, args);
        System.out.println(mr);
    }

}
