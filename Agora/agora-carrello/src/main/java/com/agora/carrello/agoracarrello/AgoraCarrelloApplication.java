package com.agora.carrello.agoracarrello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.agora.carrello.agoracarrello")
public class AgoraCarrelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgoraCarrelloApplication.class, args);
	}

}
