package RestSimulador;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSimulador {

	@Test
	public void ValidarStatus()
	{   
		// Especifique o URL base para o serviço da web RESTful
		RestAssured.baseURI = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1";
		RequestSpecification httpRequest = RestAssured.given();

		// solicitação ao servidor especificando o tipo de método e a URL do método.
		Response response = httpRequest.request(Method.GET, "/simulador");

		// verificando status do servidor
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
				
	}
	
	
	@Test
	public void ValidarHeader()
	{   
		// Especifique o URL base para o serviço da web RESTful
		RestAssured.baseURI = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1";
		RequestSpecification httpRequest = RestAssured.given();

		// solicitação ao servidor especificando o tipo de método e a URL do método.
		Response response = httpRequest.request(Method.GET, "/simulador");

		 // Validação do Content-type
		 String contentType = response.header("Content-Type");
		 assertEquals(contentType, "application/json");
		 
		 // Validação do server
		 String serverType =  response.header("Server");
		 assertEquals(serverType, "Cowboy");
		 					
	}


@Test
public void ValidarResposta()
{   
	// Especifique o URL base para o serviço da web RESTful
	RestAssured.baseURI = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1";
	RequestSpecification httpRequest = RestAssured.given();

	// solicitação ao servidor especificando o tipo de método e a URL do método.
	Response response = httpRequest.request(Method.GET, "/simulador");
	
	//Validação da Resposta
	String responseBody = response.getBody().asString();	
	assertEquals(responseBody, "{\"id\":1,\"meses\":[\"112\",\"124\",\"136\",\"148\"],\"valor\":[\"2.802\",\"3.174\",\"3.564\",\"3.971\"]}");
}
}


