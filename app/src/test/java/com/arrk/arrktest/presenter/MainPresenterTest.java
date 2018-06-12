package com.arrk.arrktest.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.usecase.GetCharactersUseCase;
import com.arrk.arrktest.view.MainView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by abhiholkar on 08/06/2018.
 */
public class MainPresenterTest {

    @Mock
    GetCharactersUseCase useCase;
    @Mock
    Context context;

    @Mock
    MainView mainView;

    MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(context, useCase);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCharacters() throws Exception {


        ConnectivityManager mockConnectivityManager = Mockito.mock(ConnectivityManager.class);
        NetworkInfo mockNetworkInfo = Mockito.mock(NetworkInfo.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager);
        when(mockNetworkInfo.isConnected()).thenReturn(true);

        TestObserver testObserver = new TestObserver();
        List<StarWarCharacter> starWarCharacterList = new ArrayList<>();
        StarWarCharacter starWarCharacter = new StarWarCharacter();
        starWarCharacterList.add(starWarCharacter);
        starWarCharacterList.add(starWarCharacter);
        when(useCase.getCharacters()).thenReturn(Observable.just(starWarCharacterList));
        useCase.getCharacters().subscribe(testObserver);
        presenter.bindView(mainView);
        presenter.getCharacters();
        testObserver.assertNoErrors();
        testObserver.assertComplete();

        verify(mainView).showList(starWarCharacterList);
    }

    @Test
    public void bindView() throws Exception {
        presenter.bindView(mainView);
        assertEquals(mainView, presenter.mainView);
    }

    @Test
    public void isNetworkAvailable() throws Exception {
        ConnectivityManager mockConnectivityManager = Mockito.mock(ConnectivityManager.class);
        NetworkInfo mockNetworkInfo = Mockito.mock(NetworkInfo.class);
        when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager);
        when(mockConnectivityManager.getActiveNetworkInfo()).thenReturn(mockNetworkInfo);
        when(mockNetworkInfo.isConnected()).thenReturn(true);
        presenter.isNetworkAvailable(context);
        verify(mockNetworkInfo).isConnected();
    }

}