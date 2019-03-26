package com.example.apprec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.apprec.Control.GestorFirebase;
import com.example.apprec.Fragmentos.LoginFragment;
import com.example.apprec.Fragmentos.RegistroFragment;
import com.example.apprec.Navegacion.NavigationHost;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity implements NavigationHost {


    private GestorFirebase gestorFirebase;
    private LoginFragment loginFragment;
    private RegistroFragment registroFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(getApplicationContext());


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contenedor, new LoginFragment())
                    .commit();
        }

    }


    @Override
    public void navegacionFragmentos(Fragment fragment) {

        if(fragment instanceof RegistroFragment) {
            this.registroFragment = (RegistroFragment) fragment;
        }
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, fragment);



        transaction.commit();
    }

}
