package com.leader.consumer.profile.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProfileServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfileServerApplication.class,args);
    }
}
