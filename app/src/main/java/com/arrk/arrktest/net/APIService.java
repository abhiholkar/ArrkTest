package com.arrk.arrktest.net;

import com.arrk.arrktest.model.CharacterListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public interface APIService {

    String BASE_URL = "https://swapi.co/api/";


    @GET("people/")
    Observable<CharacterListResponse> getCharacterList();

}
