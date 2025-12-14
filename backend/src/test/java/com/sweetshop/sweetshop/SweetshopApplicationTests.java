package com.sweetshop.sweetshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Disabled;


@SpringBootTest
@ActiveProfiles("test")
@Disabled
class SweetshopApplicationTests {

	@Test
	void contextLoads() {
	}
}
