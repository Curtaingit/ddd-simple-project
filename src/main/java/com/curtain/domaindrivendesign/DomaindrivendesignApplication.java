package com.curtain.domaindrivendesign;

import cn.wzvtcsoft.bosdomain.persist.BosJpaRepositoryImpl;
import com.curtain.domaindrivendesign.domain.events.TestEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryBaseClass = BosJpaRepositoryImpl.class)
@EnableCaching
public class DomaindrivendesignApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DomaindrivendesignApplication.class);
		springApplication.addListeners(new TestEventListener());
		springApplication.run(args);
	}
}
