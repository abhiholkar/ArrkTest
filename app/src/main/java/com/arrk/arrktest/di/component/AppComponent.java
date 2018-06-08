package com.arrk.arrktest.di.component;

import com.arrk.arrktest.MainActivity;
import com.arrk.arrktest.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abhiholkar on 07/06/2018.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);


}
