package co.asynclabs.ahuskano.arhitecture.mvp.activity;

import co.asynclabs.ahuskano.arhitecture.BaseActivity;
import co.asynclabs.ahuskano.arhitecture.mvp.presenter.Presenter;

public abstract class MVPActivity <P extends Presenter> extends BaseActivity{

    protected P presenter;

    protected void setupMVP(P presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onResume() {
        if (presenter != null) {
            presenter.onViewResumed();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (presenter != null) {
            presenter.onViewPaused();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.onViewDestroyed();
        }
        super.onDestroy();
    }

}
