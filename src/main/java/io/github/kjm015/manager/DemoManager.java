package io.github.kjm015.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import io.github.kjm015.service.DemoService;

@Component
@Slf4j
public class DemoManager {
	
	@Autowired
	DemoService demoService;
	
	public void handleHello(String msg) {
		log.info("Sending message: " + msg);
		
		try {
			demoService.doStuff(msg);
		} catch (Exception e) {
			log.error("Discord gone and shit itself: ", e);
		}
	}

}
