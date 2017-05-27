package com.gboxsw.miniac.mqttutils;

/**
 * Exception thrown by {@link MqttFactory}.
 */
public class MqttFactoryException extends RuntimeException {

	private static final long serialVersionUID = 93637508901718968L;

	public MqttFactoryException() {
		super();
	}

	public MqttFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public MqttFactoryException(String message) {
		super(message);
	}

	public MqttFactoryException(Throwable cause) {
		super(cause);
	}
}
