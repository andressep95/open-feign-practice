package cl.playground.fake.user.service.implementation;

import cl.playground.fake.user.client.FakeUserApiClient;
import cl.playground.fake.user.service.FakeUserApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeUserApiServiceImplTest {

    @Autowired
    private FakeUserApiService fakeUserApiService;

    @Test
    @DisplayName("Obteniendo data de la api")
    void getFakeUserData() throws ParseException, JsonProcessingException {
        // 1. Obtener data de la API
        Object response = fakeUserApiService.getFakeUserData();

        // 2. Convertir a JSON navegable
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.convertValue(response, JsonNode.class);
        System.out.println(node.toPrettyString());

        // 3. Acceder a campos especificos
        JsonNode contentTypeNode = node.path("headers").path("content-type");
        String contentType = contentTypeNode.isArray() && !contentTypeNode.isEmpty()
            ? contentTypeNode.get(0).asText()
            : contentTypeNode.asText();

        String gender = node.path("body").path("results").get(0).path("gender").asText();
        String name = node.path("body").path("results").get(0).path("name").path("first").asText();
        String lastName = node.path("body").path("results").get(0).path("name").path("last").asText();

        /*
        System.out.println("Content-Type: " + contentType);
        System.out.println("Gender: " + gender);
        System.out.println("Name: " + name + " " + lastName);
        94534cf9d3014853
         */

        assertNotNull(response);
        assertNotNull(name);
        assertNotNull(lastName);
        assertNotNull(gender);
        assertEquals("application/json; charset=utf-8", contentType);
    }
}