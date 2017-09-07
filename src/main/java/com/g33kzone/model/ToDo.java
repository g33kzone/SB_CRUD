package com.g33kzone.model;

import java.util.Date;
import java.util.UUID;

import io.swagger.annotations.ApiModelProperty;

public class ToDo {

	@ApiModelProperty(notes = "System generated ID", dataType = "UUID")
	private UUID taskId;
	@ApiModelProperty(notes = "To-Do task description", dataType = "String", required = true)
	private String taskDesc;
	@ApiModelProperty(notes = "To-Do task due date", dataType = "Date",required = true)
	private Date dueDate;
	@ApiModelProperty(notes = "To-Do task status", dataType = "String")
	private String taskStatus;

	public ToDo() {
		super();
	}

	public ToDo(UUID taskId, String taskDesc, Date dueDate, String taskStatus) {
		super();
		this.taskId = taskId;
		this.taskDesc = taskDesc;
		this.dueDate = dueDate;
		this.taskStatus = taskStatus;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
