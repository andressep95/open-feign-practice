package cl.playground.fake.user.client;

import cl.playground.fake.user.config.FeignLoggerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "fake-user-api-client",
    url = "${api.fake-user.url}",
    path = "${api.fake-user.base.path}",
    configuration = FeignLoggerConfig.class
)
public interface FakeUserApiClient {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getFakeUser();

}
