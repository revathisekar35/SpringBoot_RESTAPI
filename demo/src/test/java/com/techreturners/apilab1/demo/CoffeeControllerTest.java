package com.techreturners.apilab1.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CoffeeControllerTest {
	@Autowired
	private MockMvc mockMvcController;

	@Test
	public void TestCoffeeLover() throws Exception {
		String expected = "I love Coffee";
		this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffeelover"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(expected));

	}
	
	@Test
	public void TestGetCoffeeWithoutRequestParam() throws Exception {
		String expected = "latte";
		this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expected));

	}
	
	@Test
	public void TestGetCoffeeWithRequestParam() throws Exception {
		String expected = "Cappuccino";
		this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee").param("name", "Cappuccino"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expected));

	}

}
