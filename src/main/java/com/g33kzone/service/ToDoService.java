package com.g33kzone.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.g33kzone.SbCrudApplication;
import com.g33kzone.model.ToDo;

@Service
public class ToDoService {

	public List<ToDo> fetchActiveTasks(String taskStatus) {

		return SbCrudApplication.toDoList.stream().filter(t -> taskStatus.equals(t.getTaskStatus()))
				.collect(Collectors.toList());
	}

	public List<ToDo> addTask(ToDo toDoTask) {

		toDoTask.setTaskId(UUID.randomUUID());

		SbCrudApplication.toDoList.add(toDoTask);

		System.out.println("New Task " + toDoTask.getTaskDesc());

		return SbCrudApplication.toDoList;
	}

	public String updateTask() {

		return "Task updated successfully";

	}

	public String deleteTask() {

		return "Task deleted successfully";

	}
}
