package com.vanhack.leap.javatraining;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanhack.leap.javatraining.controller.LeapController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaTrainingApplicationTests {

	@Test
	public void contextLoads() {

		// scenario
		LeapController leap = new LeapController();

		// action
		String actual = leap.hello("Edylle");

		// verification
		assertEquals("Hello Edylle", actual);

	}

}
