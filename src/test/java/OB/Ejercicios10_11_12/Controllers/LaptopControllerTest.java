package OB.Ejercicios10_11_12.Controllers;

import OB.Ejercicios10_11_12.Entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> respuestaHTTP = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, respuestaHTTP.getStatusCode());
        assertEquals(200, respuestaHTTP.getStatusCodeValue());
        List<Laptop> properties = Arrays.asList(respuestaHTTP.getBody());
        System.out.println(properties.size()); // mostramos el tamaño
    }

    @Test
    void findById() {
        ResponseEntity<Laptop[]> respuestaHTTP = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.NOT_FOUND, respuestaHTTP.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                   {
                           "marca": "Laptop creada desde Spring Test",
                           "discoSolido": true,
                           "memRAM": 8,
                           "gbDisco": 256,
                           "pulgadasPant": 15.5,
                           "procesador": "AMD Radeon RX Vega 8"
                       }                
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
                                                                        //   url       metodo           peticion   clase que devolvemos
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop resultado = response.getBody();

        assertEquals(1L, resultado.getId());
        assertEquals("Laptop creada desde Spring Test", resultado.getMarca());

    }

    @Test
    void update() {

    }

    @Test
    void delete() {
    }

    @Test
    void borrarTodo() {
    }
}