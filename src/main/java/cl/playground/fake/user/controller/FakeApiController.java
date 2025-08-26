package cl.playground.fake.user.controller;

import cl.playground.fake.user.service.FakeUserApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.logging.Logger;

@RestController
public class FakeApiController {

    private static final Logger logger = Logger.getLogger(FakeApiController.class.getName());
    private final FakeUserApiService fakeUserApiService;

    public FakeApiController(FakeUserApiService fakeUserApiService) {
        this.fakeUserApiService = fakeUserApiService;
    }

    @GetMapping()
    ResponseEntity<Object> getFakeUser() throws JsonProcessingException, ParseException {
        logger.info("[GET] Entrada del servicio");

        return new ResponseEntity<>(fakeUserApiService.getFakeUserData(), HttpStatus.OK);
    }
}
