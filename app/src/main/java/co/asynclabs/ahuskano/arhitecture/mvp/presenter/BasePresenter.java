package co.asynclabs.ahuskano.arhitecture.mvp.presenter;

import co.asynclabs.ahuskano.arhitecture.mvp.view.View;

public abstract class BasePresenter <V extends View> implements Presenter {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public void initialize(Object... parameters) {

    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewPaused() {

    }

    @Override
    public void onViewDestroyed() {

    }

}

