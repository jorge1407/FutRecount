package com.example.apprec.Control;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.apprec.Fragmentos.AgregarPartidosFragment;
import com.example.apprec.Fragmentos.LoginFragment;
import com.example.apprec.Navegacion.NavigationHost;
import com.example.apprec.Modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GestorFirebase{
    private FirebaseAuth mAuth;
    private Activity activity;
    private DatabaseReference bbdd;


    //CODE FORMAT

    public GestorFirebase(Activity activity) {
        mAuth = FirebaseAuth.getInstance();
        this.activity = activity;
    }

    public void loginUser(final String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Log.d("JORGE", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            ((NavigationHost)activity).navegacionFragmentos(new AgregarPartidosFragment());


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Jorge", "createUserWithEmail:failure", task.getException());


                        }

                        // ...
                    }
                });
    }

    public void registrarUser(final String email, final String password, final Usuario u) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            u.setClaveUsuario(getIdUsuario());
                            guardarDatos(u);
                            mAuth.signOut();
                            ((NavigationHost) activity).navegacionFragmentos(new LoginFragment());
                        } else {
                            Log.d("Jorge","PRIROPO"+task.getException());

                        }

                    }
                });
    }

    public void guardarDatos(Usuario u) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Usuarios");
        database.child(getIdUsuario()).setValue(u);
    }


    public String getIdUsuario() {
        return mAuth.getCurrentUser().getUid();
    }
}