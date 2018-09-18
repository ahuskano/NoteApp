package co.asynclabs.ahuskano.arhitecture.mvp.presenter;

public interface Presenter {

    void initialize(Object... parameters);

    void onViewCreated();

    void onViewResumed();

    void onViewPaused();

    void onViewDestroyed();

}
