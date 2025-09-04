package cl.playground.fake.user.service.implementation;

import cl.playground.fake.user.client.FakeUserApiClient;
import cl.playground.fake.user.dto.FakeUserResponse;
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
        FakeUserResponse response = fakeUserApiService.getFakeUserData();
        System.out.println(response);

    }
}