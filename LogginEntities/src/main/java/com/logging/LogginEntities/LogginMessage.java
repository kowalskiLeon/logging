package com.logging.LogginEntities;

public class LogginMessage {
	
	private Long id;
	private String message;
	private LogginCodeEnum code;
	private String timestamp;
	private String description;
	
	
	
	public LogginMessage(Long id, String message, LogginCodeEnum code, String timestamp, String description) {
		super();
		this.id = id;
		this.message = message;
		this.code = code;
		this.timestamp = timestamp;
		this.description = description;
	}
	
	public LogginMessage() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LogginCodeEnum getCode() {
		return code;
	}
	public void setCode(LogginCodeEnum code) {
		this.code = code;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "timestamp=" + timestamp +":: id=" + id + ", message=" + message + ", code=" + code  
				+ ", description=" + description;
	}

	
	
	
}
