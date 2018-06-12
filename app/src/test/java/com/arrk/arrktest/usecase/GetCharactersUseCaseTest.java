package com.arrk.arrktest.usecase;

import com.arrk.arrktest.data.CharactersRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by abhiholkar on 08/06/2018.
 */
public class GetCharactersUseCaseTest {

    @Mock
    CharactersRepository charactersRepository;

    GetCharactersUseCase useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetCharactersUseCase(charactersRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCharacters() throws Exception {
        Observable mockObservable = Mockito.mock(Observable.class);
        when(charactersRepository.getCharacterList()).thenReturn(mockObservable);
        useCase.getCharacters();
        assertNotNull(charactersRepository);
        verify(charactersRepository).getCharacterList();
    }


}