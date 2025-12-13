package com.sweetshop.sweetshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class SweetshopApplicationTests {

	@Configuration
	static class TestConfig {
		// empty config: prevents Spring from auto-wiring the DB
	}

	@Test
	void contextLoads() {
		// This test just checks the Spring context loads without DB
	}
}
