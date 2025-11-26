package com.logging.LoggingEntities;

public class LoggingMessage {
	
	private Long id;
	private String message;
	private LoggingCodeEnum code;
	private String timestamp;
	private String description;
	
	
	
	public LoggingMessage(Long id, String message, LoggingCodeEnum code, String timestamp, String description) {
		super();
		this.id = id;
		this.message = message;
		this.code = code;
		this.timestamp = timestamp;
		this.description = description;
	}
	
	public LoggingMessage() {
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
	public LoggingCodeEnum getCode() {
		return code;
	}
	public void setCode(LoggingCodeEnum code) {
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
