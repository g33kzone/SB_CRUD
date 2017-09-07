package com.g33kzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g33kzone.SbCrudApplication;
import com.g33kzone.model.ToDo;
import com.g33kzone.service.ToDoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/to-do")
@Api(value="Sample CRUD Webservice")
public class ToDoController {

	@Autowired
	public ToDoService toDoService;

	@ApiOperation(value="View all available To-Do tasks", response=ResponseEntity.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved To-Do task list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ToDo>> fetchAllTasks() {

		return ResponseEntity.status(HttpStatus.OK).body(SbCrudApplication.toDoList);
	}

	@ApiOperation(value="Show To-Do tasks as per their status :: unassigned/inprogress/done ", response=ResponseEntity.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved To-Do tasks"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(path = "/task/{taskStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ToDo>> fetchActiveTasks(@PathVariable String taskStatus) {

		return ResponseEntity.status(HttpStatus.OK).body(toDoService.fetchActiveTasks(taskStatus));
	}
	
	@ApiOperation(value="Add a new To-Do task", response=ResponseEntity.class)
	@PostMapping(path = "/task", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ToDo>> addTask(@RequestBody ToDo toDoTask) {

		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.addTask(toDoTask));
	}

	@ApiOperation(value="Update a To-Do task", response=ResponseEntity.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 204, message = "Successfully updated To-Do task"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@PutMapping(path = "/task", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateTask() {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(toDoService.updateTask());
	}

	@ApiOperation(value="Delete a To-Do task", response=ResponseEntity.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 204, message = "Successfully deleted To-Do task"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@DeleteMapping(path = "/task", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteTask() {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(toDoService.deleteTask());
	}

}
