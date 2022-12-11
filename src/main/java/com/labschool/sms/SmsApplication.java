package com.labschool.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmsApplication.class, args);
  }

  @Bean
  @Profile("local")
  public FlywayMigrationStrategy cleanMigrateStrategy() {
    return flyway -> {
      flyway.clean();
      flyway.migrate();
    };
  }

}
