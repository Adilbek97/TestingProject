package ru.trener.testingproject.ui.base.presenters;

import com.arellomobile.mvp.MvpPresenter;

import ru.trener.testingproject.App;
import ru.trener.testingproject.di.services.Api;
import ru.trener.testingproject.di.services.BaseService;
import ru.trener.testingproject.ui.base.views.BaseView;

public class BasePresenter<View extends BaseView> extends MvpPresenter<View> {
    BaseService baseService = new BaseService();

    View view;

    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public BasePresenter() {
        App.applicationComponent.inject(baseService);
    }

    private Api api;

    public BaseService getBaseService() {
        return baseService;
    }

    public Api getApi() {
        return baseService.api;
    }
}
