package service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

@Service
@Slf4j
public class DemoService {
	
	private static final String webhook = "https://discordapp.com/api/webhooks/462379781615255582/vgSiT7An59T96vzGWrFv3YZDM482t5pnqEh57ulddfkpg-3SG0k1AKN8KrTKByPzLoRc";
	private static final String token = "NDYyMzc5MjIxMjUyMzA5MDAy.Dhg_zA.BBosSM7vXXaA5hl3w9DP4jT7AMk";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void doStuff(String fun) throws LoginException, RateLimitedException, InterruptedException {
		JDA jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
		
		long ping = jda.getPing();
		
		restTemplate.postForLocation(webhook, fun + ", and the current ping is now " + ping);
		log.info("posted to Discord");
	}

}
