package cl.playground.fake.user.service;

import cl.playground.fake.user.dto.FakeUserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;

public interface FakeUserApiService {

    FakeUserResponse getFakeUserData() throws JsonProcessingException, ParseException;

    FakeUserResponse getFakeUserData(int page, int results) throws JsonProcessingException;

}
