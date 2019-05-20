package uz.alm.di.auth;

import javax.inject.Singleton;

import dagger.Component;
import uz.alm.ui.login.auth.presenter.AuthPresenter;

@Component(modules = AuthModule.class)
@Singleton
public interface AuthComponent {
    void inject(AuthPresenter presenter);
}
