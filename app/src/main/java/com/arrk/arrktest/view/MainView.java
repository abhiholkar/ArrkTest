package com.arrk.arrktest.view;

import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.net.APIError;

import java.util.List;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public interface MainView extends IView {
    void showLoading();

    void showError(APIError error);

    void hideLoading();

    void showList(List<StarWarCharacter> characterList);
}
