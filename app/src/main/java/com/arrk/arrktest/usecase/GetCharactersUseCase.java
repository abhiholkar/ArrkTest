package com.arrk.arrktest.usecase;

import com.arrk.arrktest.data.CharactersRepository;
import com.arrk.arrktest.model.StarWarCharacter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class GetCharactersUseCase {

    CharactersRepository charactersRepository;

    @Inject
    public GetCharactersUseCase(CharactersRepository repository) {
        charactersRepository =  repository;
    }

    public Observable<List<StarWarCharacter>> getCharacters(){
        return charactersRepository.getCharacterList();
    }
}
