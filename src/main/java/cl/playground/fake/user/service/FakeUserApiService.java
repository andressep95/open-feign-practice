package cl.playground.fake.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;

public interface FakeUserApiService {

    Object getFakeUserData() throws JsonProcessingException, ParseException;

}
