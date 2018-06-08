package com.arrk.arrktest.net;

import com.arrk.arrktest.model.CharacterListResponse;
import com.arrk.arrktest.model.StarWarCharacter;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public interface APIService {

    public final String BASE_URL = "https://swapi.co/api/";


    @GET("people/")
    Observable<CharacterListResponse> getCharacterList();

}
