package cl.playground.fake.user.client;

import cl.playground.fake.user.config.FeignLoggerConfig;
import cl.playground.fake.user.dto.FakeUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "fake-user-api-client",
    url = "${api.fake-user.url}",
    path = "${api.fake-user.base.path}",
    configuration = FeignLoggerConfig.class
)
public interface FakeUserApiClient {

    @GetMapping(value = "?inc=gender,name,location", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FakeUserResponse> getFakeUser(@RequestParam("inc") String includedField);

    @GetMapping(value = "?inc=gender,name,location", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FakeUserResponse> getFakeUserPaginated(
        @RequestParam("inc")
        String includedField, @RequestParam("page") int page, @RequestParam("results") int results);
}
