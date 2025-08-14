package com.harish.Dapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.harish.Dapp.DTO.BlockchainProperties;

@SpringBootApplication
@EnableConfigurationProperties(BlockchainProperties.class)
public class BlockChainAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockChainAppBackendApplication.class, args);
	}

}
