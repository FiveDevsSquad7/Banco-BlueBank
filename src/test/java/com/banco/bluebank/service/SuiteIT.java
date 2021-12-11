package com.banco.bluebank.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;



import io.restassured.RestAssured;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
@SuiteClasses({AgenciaEndPointIT.class,
	ContaEndPointIT.class,
	CorrentistaEndPointIT.class,
	MovimentacaoEndPointIT.class,
	AgenciaIT.class,
	CorrentistaIT.class,
	ContaIT.class,
	MovimentacaoIT.class })
public class SuiteIT {

	
	@LocalServerPort
	private int Webport;
	
	@Before
	public void iniciar() {
		RestAssured.port = Webport;
	}
	
}
