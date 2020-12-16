package com.orange.facade.apikataromannumber.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@RunWith(MockitoJUnitRunner.class)
public class ArabicToRomanConversionControllerTest {

	@InjectMocks
	ArabicToRomanConversionController controller;
	
	@Test
	public void testGetRomanConversion() throws Exception {
		//setup
		String valueToConvert = null;
		
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(valueToConvert);
		
		//Assert
		assertThat(romanConversion.getStatusCodeValue()).isEqualTo(200);
		assertThat(romanConversion.getBody()).isNotNull();
		assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
		assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
	}

}
