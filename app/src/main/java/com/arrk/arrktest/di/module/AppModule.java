package com.arrk.arrktest.di.module;

import android.app.Application;
import android.content.Context;

import com.arrk.arrktest.data.CharactersRepository;
import com.arrk.arrktest.net.APIService;
import com.arrk.arrktest.presenter.MainPresenter;
import com.arrk.arrktest.usecase.GetCharactersUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhiholkar on 07/06/2018.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    MainPresenter providesMainPresenter(Context context, GetCharactersUseCase useCase) {
        return new MainPresenter(context, useCase);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    GetCharactersUseCase providesGetCharactersUseCase(CharactersRepository charactersRepository) {
        return new GetCharactersUseCase(charactersRepository);
    }

    @Provides
    CharactersRepository providesCharacterRepository(Retrofit retrofit) {
        return new CharactersRepository(retrofit);
    }

}
