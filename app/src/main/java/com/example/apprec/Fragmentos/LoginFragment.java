package com.example.apprec.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprec.Control.GestorFirebase;
import com.example.apprec.Navegacion.NavigationHost;
import com.example.apprec.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    // EditText
    private EditText etEmail;
    private EditText etPassword;

    //Buttons
    private Button btnLogin;
    private Button btnRegistrar;

    //Controladores
    private GestorFirebase gestorFirebase;




    // TODO: Rename and change types of parameters



    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        etEmail = v.findViewById(R.id.etEmail);
        etPassword = v.findViewById(R.id.etPassword);
        btnLogin = v.findViewById(R.id.btnLogin);
        btnRegistrar = v.findViewById(R.id.btnRegistrar);

        gestorFirebase = new GestorFirebase(getActivity());

        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        gestorFirebase = new GestorFirebase(getActivity());

        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }





    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnLogin:
                    if(comprobarDatos()){
                        gestorFirebase.loginUser(etEmail.getText().toString(),etPassword.getText().toString());
                    }else
                        {
                            Toast.makeText(getActivity(),"Error comprueba los campos",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btnRegistrar:
                    ((NavigationHost)getActivity()).navegacionFragmentos(new RegistroFragment());

                    break;

            }


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    private boolean comprobarDatos() {
        if(etEmail.getText().toString().compareToIgnoreCase("") == 0 || etPassword.getText().toString().compareToIgnoreCase("") == 0) {
            return false;
        } else {
            return true;
        }
    }

}
