package com.orange.facade.apikataromannumber.integration.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;

public class ArabicToRomanConversionControllerIntegrationTest extends AbstractIntegrationTest {

	@Before
	public void setup() throws Exception {
		super.setUp();
	}

	@Test
	public void getCCO_KO_Error_4XX_Because_OrderId_not_Find_in_Referential() throws Exception {
		//Setup

		mvc.perform(
				//Test
				get("/ArabicToRoman?valueToConvert=10"))
				.andDo(print())

				//Assert
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.valueToConvert").value("null"))
				.andExpect(jsonPath("$.response").value("null"));
	}

}
