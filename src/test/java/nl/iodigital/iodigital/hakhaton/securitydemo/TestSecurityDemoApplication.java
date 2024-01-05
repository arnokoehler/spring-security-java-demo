package nl.iodigital.iodigital.hakhaton.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(SecurityDemoApplication::main).with(TestSecurityDemoApplication.class).run(args);
	}

}
