package com.arrk.arrktest.data;

import com.arrk.arrktest.model.CharacterListResponse;
import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.net.APIService;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class CharactersRepository {


    Retrofit retrofit;

    @Inject
    public CharactersRepository(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Observable<List<StarWarCharacter>> getCharacterList(){

       return retrofit.create(APIService.class).getCharacterList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(new Function<CharacterListResponse, List<StarWarCharacter>>() {
                   @Override
                   public List<StarWarCharacter> apply(CharacterListResponse characterListResponse) throws Exception {
                       if(characterListResponse==null ) throw new NullPointerException();
                       return characterListResponse.getResults();
                   }
               });
    }
}
