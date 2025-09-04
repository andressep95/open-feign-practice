package cl.playground.fake.user.controller;

import cl.playground.fake.user.dto.FakeUserResponse;
import cl.playground.fake.user.service.FakeUserApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/paginated")
    ResponseEntity<FakeUserResponse> getFakeUser(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "results", defaultValue = "10") int results) throws JsonProcessingException {
        logger.info(String.format("[GET] Entrada del servicio con página %d y %d resultados.", page, results));
        FakeUserResponse response = fakeUserApiService.getFakeUserData(page, results);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
