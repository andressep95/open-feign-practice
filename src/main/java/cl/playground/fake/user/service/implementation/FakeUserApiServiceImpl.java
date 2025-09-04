package cl.playground.fake.user.service.implementation;

import cl.playground.fake.user.client.FakeUserApiClient;
import cl.playground.fake.user.dto.FakeUserResponse;
import cl.playground.fake.user.service.FakeUserApiService;

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
    private static final String INCLUDED_FIELDS = "gender,name,location";

    public FakeUserApiServiceImpl(FakeUserApiClient fakeUserApiClient) {
        this.fakeUserApiClient = fakeUserApiClient;
    }

    @Override
    public FakeUserResponse getFakeUserData() {
        try {
            logger.info("[GET] Llamando a FakeUserApi para traer solo la ubicación.");
            ResponseEntity<FakeUserResponse> response = fakeUserApiClient.getFakeUser(INCLUDED_FIELDS);
            return response.getBody();
        } catch (FeignException e) {
            logger.log(
                Level.SEVERE,
                String.format("[GET - status: %s] Error llamando a FakeUserApi, respuesta fallida: %s", e.status(), e.contentUTF8())
                      );
            return null;
        }
    }

    @Override
    public FakeUserResponse getFakeUserData(int page, int results) {
        try {
            logger.info(String.format("[GET] Llamando a FakeUserApi para la página %d con %d resultados.", page, results));
            ResponseEntity<FakeUserResponse> response = fakeUserApiClient.getFakeUserPaginated(INCLUDED_FIELDS, page,
                results);
            return response.getBody();
        } catch (FeignException e) {
            logger.log(
                Level.SEVERE,
                String.format("[GET - status: %s] Error llamando a FakeUserApi, respuesta fallida: %s", e.status(), e.contentUTF8())
                      );
            return null;
        }
    }
}
