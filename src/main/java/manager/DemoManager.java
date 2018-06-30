package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import service.DemoService;

@Component
@Slf4j
public class DemoManager {
	
	@Autowired
	DemoService demoService;
	
	private static final Logger log = LoggerFactory.getLogger(Logger.class);
	
	public void handleHello(String msg) {
		log.info("Sending message: " + msg);
		
		try {
			demoService.doStuff(msg);
		} catch (Exception e) {
			log.error("Discord gone and shit itself: ", e);
		}
	}

}
