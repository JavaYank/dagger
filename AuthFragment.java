package uz.alm.ui.login.auth.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import uz.alm.R;
import uz.alm.di.auth.AuthComponent;
import uz.alm.di.auth.AuthModule;
import uz.alm.di.auth.DaggerAuthComponent;
import uz.alm.ui.login.auth.presenter.AuthPresenter;

public class AuthFragment extends MvpAppCompatFragment implements AuthView {

    @InjectPresenter
    AuthPresenter presenter;
    @BindView(R.id.input_phn_num_login)
    MaskedEditText inputLogin;
    @BindView(R.id.input_pass_login)
    MaskedEditText inputPass;
    @BindView(R.id.btn_auth)
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthComponent component = DaggerAuthComponent.builder().authModule(new AuthModule()).build();
        component.inject(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        ButterKnife.bind(this, view);
        btn.setOnClickListener(v -> {
            if (presenter.sayHello(inputLogin.getRawText(), inputPass.getRawText())){
                Toast.makeText(getActivity().getApplicationContext(), "Yes!!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
