package com.sweetshop.sweetshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(DataSourceAutoConfiguration.class) // temporarily import to avoid context errors
class SweetshopApplicationTests {

	@Test
	void contextLoads() {
	}
}
