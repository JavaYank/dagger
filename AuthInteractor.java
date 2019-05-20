package uz.alm.domain;

public class AuthInteractor {

    public boolean auth(String login, String password) {
        return !login.isEmpty() || !password.isEmpty();
    }
}
