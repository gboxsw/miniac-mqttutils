package com.gboxsw.miniac.samples.mqttutils_basic;

import java.io.*;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.*;

import com.gboxsw.miniac.mqttutils.MqttFactory;

/**
 * Simple demo of {@link MqttFactory}
 */
public class App {

	public static void main(String[] args) throws MqttSecurityException, MqttException {
		MqttFactory mqttFactory = new MqttFactory();
		mqttFactory.setPropertiesFromFile(new File("mqtt.txt"));

		System.out.println("Factory setup:");
		Map<String, String> properties = mqttFactory.getProperties(false);
		for (String property : properties.keySet()) {
			System.out.println(" " + property + " = " + properties.get(property));
		}
		System.out.println();

		System.out.println("Connecting...");
		IMqttClient client = mqttFactory.createClient();
		client.connect(mqttFactory.createConnectOptions());
		System.out.println("Connected");

		System.out.println("Publishing...");
		MqttMessage message = mqttFactory.createMessage("hello".getBytes());
		client.publish("miniac/test", message);

		System.out.println("Disconnecting...");
		client.disconnect();
		System.out.println("Disconnected");
	}
}
