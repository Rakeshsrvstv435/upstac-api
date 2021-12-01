package org.upgrad.upstac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class UpstacApplication {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: "+dateString);
		System.out.println(LocalDateTime.now().toLocalTime().toString());
		SpringApplication.run(UpstacApplication.class, args);
	}


}
