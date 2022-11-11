package com.project.store;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.store.Requests.OrderRequest;

@SpringBootTest
@AutoConfigureMockMvc
class StoreApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	OrderRequest orderRequest = new OrderRequest(35455, 1, null);

	@Test
	void shouldGetResponse_Ok() throws Exception {

		orderRequest.setApplicationDate("2020-06-15 00:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk());
	}

	@Test
	void shouldGetResponse_BadRequest() throws Exception {

		orderRequest.setApplicationDate("2020/06/15-00.00.00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isBadRequest());
	}

	@Test
	void shouldGetCorrectFinalPrice_1() throws Exception {

		orderRequest.setApplicationDate("2020-06-14 10:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandsId").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tax").value(18.33))
		.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));

	}

	@Test
	void shouldGetCorrectFinalPrice_2() throws Exception {

		orderRequest.setApplicationDate("2020-06-14 16:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandsId").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tax").value(15.17))
		.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(25.45))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00"));

	}

	@Test
	void shouldGetCorrectFinalPrice_3() throws Exception {

		orderRequest.setApplicationDate("2020-06-14 21:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandsId").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tax").value(18.33))
		.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));

	}

	@Test
	void shouldGetCorrectFinalPrice_4() throws Exception {

		orderRequest.setApplicationDate("2020-06-15 10:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandsId").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tax").value(1.66))
		.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(30.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"));

	}

	@Test
	void shouldGetCorrectFinalPrice_5() throws Exception {

		orderRequest.setApplicationDate("2020-06-16 21:00:00");

		mockMvc.perform(MockMvcRequestBuilders
		.get("/store/finalPrice")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(asJsonString(orderRequest))
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandsId").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tax").value(29.83))
		.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(38.95))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
