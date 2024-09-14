package com.base.clicker.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.clicker.producers.EventProducer;

@RestController
@RequestMapping("/api/")
public class EventController {
	private final String topic = "click-events";
	private final String bootstrapServer = "localhost:9092";

	@PostMapping("event")
	public ResponseEntity<String> index(@RequestBody List<String> data) {
		EventProducer producer = new EventProducer(bootstrapServer, topic);
		
		producer.sendEvent(data.get(0), data.get(1));
		producer.close();

		return ResponseEntity.ok().build();
	}
}