package cl.playground.fake.user.service.implementation;

import cl.playground.fake.user.client.FakeUserApiClient;
import cl.playground.fake.user.service.FakeUserApiService;
import cl.playground.fake.user.util.JsonFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FakeUserApiServiceImpl implements FakeUserApiService {

    private final FakeUserApiClient fakeUserApiClient;
    private static final Logger logger = Logger.getLogger(FakeUserApiServiceImpl.class.getName());

    public FakeUserApiServiceImpl(FakeUserApiClient fakeUserApiClient) {
        this.fakeUserApiClient = fakeUserApiClient;
    }

    @Override
    public Object getFakeUserData() throws JsonProcessingException, ParseException {
        try {
            ResponseEntity<Object> fakeApiResponse;

            logger.info("[GET] Llamando a FakeUserApi en el servicio");
            return fakeApiResponse = fakeUserApiClient.getFakeUser();

        } catch (FeignException e) {
            logger.log(
                Level.SEVERE,
                String.format("[GET - status: %s] Error llamando a FakeUserApi, response fallido: %s", e.status(),
                    e.contentUTF8()
                )
            );
            return JsonFormatter.jsonStringToObject(e.contentUTF8());

        }
    }
}
