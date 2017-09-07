package com.g33kzone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.g33kzone.model.ToDo;
import com.g33kzone.utility.DateFormat;
import com.g33kzone.utility.StatusEnum;

@SpringBootApplication
public class SbCrudApplication {

	// Initialize List
	public static List<ToDo> toDoList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(SbCrudApplication.class, args);

		//
		toDoList.add(new ToDo(UUID.randomUUID(), "Welcome to Spring Boot..", DateFormat.currentDate(),
				StatusEnum.TaskStatus.done.toString()));

		toDoList.add(new ToDo(UUID.randomUUID(), "Spring Boot :: Lets get started..", DateFormat.currentDate(),
				StatusEnum.TaskStatus.done.toString()));

		toDoList.add(new ToDo(UUID.randomUUID(), "Spring Boot :: CRUD Webservice..", DateFormat.currentDate(),
				StatusEnum.TaskStatus.inprogress.toString()));
	}
}
