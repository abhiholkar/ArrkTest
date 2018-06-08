package com.arrk.arrktest.presenter;

import android.content.Context;

import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.net.APIError;
import com.arrk.arrktest.usecase.GetCharactersUseCase;
import com.arrk.arrktest.utils.NetworkUtils;
import com.arrk.arrktest.view.IView;
import com.arrk.arrktest.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class MainPresenter extends BasePresenter{

    GetCharactersUseCase useCase;

    Context context;

    MainView mainView;

    @Inject
    public MainPresenter(Context context,GetCharactersUseCase useCase) {
        this.context=context;
        this.useCase = useCase;
    }


    public void getCharacters() {
        if (!isNetworkAvailable(context)) {
            mainView.showError(APIError.NETWORK_ERROR);
        }
        useCase.getCharacters().subscribe(new DisposableObserver<List<StarWarCharacter>>() {
            @Override
            public void onNext(List<StarWarCharacter> starWarCharacters) {
                mainView.showList(starWarCharacters);
            }

            @Override
            public void onError(Throwable e) {
                mainView.showError(APIError.GENERAL_ERROR);

            }

            @Override
            public void onComplete() {

            }
        });

    }

    /*public void bindView(MainView view) {
        this.mainView = view;

    }*/

    //For test
    protected boolean isNetworkAvailable(Context context) {
        return NetworkUtils.isNetworkAvailable(context);
    }

    @Override
    public void bindView(IView view) {
        this.mainView = (MainView) view;

    }
}
