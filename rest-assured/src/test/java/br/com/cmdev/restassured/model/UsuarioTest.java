package br.com.cmdev.restassured.model;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

class UsuarioTest {

	private Usuario userCalixto;
	private Usuario userRosy;

	@BeforeEach
	public void setUp() {
		
		RestAssured.baseURI = "http://192.168.0.10/leilao-ws";
		RestAssured.port = 8081;
		
		userCalixto = new Usuario(1L, "Calixto Macedo", "calixto.macedo@gmail.com");
		userRosy = new Usuario(2L, "Rosimeire Cunegundes", "rosy.macedo@gmail.com");
	}

	@Test
	public void deveRetornarListaDeUsuariosXml() {
		XmlPath path = given()
				.header("Accept", "application/xml")
				.get("/usuario/list")
				.andReturn()
				.xmlPath();

		Usuario calixto = path.getObject("usuarioes.usuario[0]", Usuario.class);
		Usuario rosy = path.getObject("usuarioes.usuario[1]", Usuario.class);

		assertEquals(userCalixto.getNome(), calixto.getNome());
		assertEquals(userRosy.getNome(), rosy.getNome());
	}

	@Test
	public void deveRetornarListaDeUsuariosJson() {
		JsonPath path = given()
				.header("Accept", "application/json")
				.get("/usuario/1")
				.andReturn()
				.jsonPath();

		Usuario usuario = path.getObject("", Usuario.class);

		assertEquals(userCalixto.getNome(), usuario.getNome());
	}

	@Test
	public void deveAdicionarUmUsuario() {
		Usuario izabel = new Usuario(3l, "Izabel Macedo", "izabel.macedo@gmail.com");
		XmlPath path = given()
				.header("Accept", "application/xml")
				.contentType("application/xml")
				.body(izabel)
				.expect().statusCode(201)
				.when().post("/usuario")
				.andReturn()
				.xmlPath();
		
		Usuario usuario = path.getObject("usuario", Usuario.class);
		assertEquals("Izabel Macedo", usuario.getNome());
		assertEquals("izabel.macedo@gmail.com", usuario.getEmail());
	}

}
