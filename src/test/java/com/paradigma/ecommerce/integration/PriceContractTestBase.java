package com.paradigma.ecommerce.integration;


import com.paradigma.ecommerce.infraestructure.repository.TestPriceJpaRepository;
import com.paradigma.ecommerce.interfaces.rest.PriceApiController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceContractTestBase {


	@Autowired
	private PriceApiController priceApiController;

	@Autowired
	private TestPriceJpaRepository testPriceJpaRepository;



	@BeforeEach
	public void setup() {
		final var standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(priceApiController);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
		RestAssuredMockMvc.postProcessors();

	}

	@AfterAll
	public void clear() {
		testPriceJpaRepository.deleteAll();
	}
}
