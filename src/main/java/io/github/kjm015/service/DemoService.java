package io.github.kjm015.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${discord.hook}")
	private String webHook;

	@Value("${discord.token}")
	private String token;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void doStuff(String fun) throws LoginException, InterruptedException {
		JDA jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();

		long ping = jda.getPing();
		
		restTemplate.postForLocation(webHook, fun + ", and the current ping is now " + ping);
		log.info("posted to Discord");
	}

}
