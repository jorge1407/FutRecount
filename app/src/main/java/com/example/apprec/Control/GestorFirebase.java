package com.example.apprec.Control;

import android.app.Activity;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.apprec.LoginFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GestorFirebase {
    private FirebaseAuth mAuth;
    private Activity activity;
    //CODE FORMAT

    public GestorFirebase(Activity activity) {
        mAuth = FirebaseAuth.getInstance();
        this.activity = activity;
    }
    public void loginUser(final String email, final String password){
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Log.d("JORGE", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Jorge", "createUserWithEmail:failure", task.getException());


                        }

                        // ...
                    }
                });
    }



}
