package uz.alm.di.auth;

import dagger.Module;
import dagger.Provides;
import uz.alm.domain.AuthInteractor;

@Module
public class AuthModule {
    @Provides
    AuthInterator provideAuthInteractor() {
        return new AuthInteractor();
    }
}
