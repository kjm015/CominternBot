package io.github.kjm015;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import javax.security.auth.login.LoginException;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	@Value("${discord.token}")
	private String token;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public JDA discord() throws LoginException, InterruptedException {
		return new JDABuilder(AccountType.BOT)
				.setToken(token)
				.setStatus(OnlineStatus.ONLINE)
				.setGame(Game.watching("The Revolution"))
				.buildBlocking();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		log.info("App is running!");
	}
}
