package uz.alm.ui.login.auth.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import uz.alm.di.auth.AuthComponent;
import uz.alm.di.auth.DaggerAuthComponent;
import uz.alm.domain.AuthInteractor;
import uz.alm.ui.login.auth.view.AuthView;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView> {

    @Inject
    AuthInteractor interactor;

    public AuthPresenter() {

    }

    public boolean sayHello(String login, String pass) {
        return interactor.auth(login, pass);
    }
}
