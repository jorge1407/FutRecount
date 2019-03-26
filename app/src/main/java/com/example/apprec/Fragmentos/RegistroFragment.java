package com.example.apprec.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apprec.Control.GestorFirebase;
import com.example.apprec.Navegacion.NavigationHost;
import com.example.apprec.R;
import com.example.apprec.Modelos.Usuario;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link RegistroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragment extends Fragment implements View.OnClickListener {

    private EditText etNombre;
    private EditText etApellido;
    private EditText etEmailRegistro;
    private EditText etPasswordRegistro;
    private EditText etTelefono;

    private Button btnRegistrarse;
    private Button btnCancelar;


    private GestorFirebase gestorFirebase;




    public RegistroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroFragment.
     */
    public static RegistroFragment newInstance(String param1, String param2) {
        RegistroFragment fragment = new RegistroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_registro, container, false);

        etNombre = v.findViewById(R.id.etNombre);
        etApellido = v.findViewById(R.id.etApellidos);
        etEmailRegistro = v.findViewById(R.id.etEmailRegistro);
        etPasswordRegistro = v.findViewById(R.id.etPasswordRegistro);
        etTelefono = v.findViewById(R.id.etTelefono);


        btnRegistrarse = v.findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(this);
        btnCancelar=v.findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);

        gestorFirebase =  new GestorFirebase(getActivity());

        return v;


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRegistrarse:
                Usuario u = new Usuario(etNombre.getText().toString(),etApellido.getText().toString(),etEmailRegistro.getText().toString(),etPasswordRegistro.getText().toString(),etTelefono.getText().toString());
                gestorFirebase.registrarUser(etEmailRegistro.getText().toString(),etPasswordRegistro.getText().toString(),u);
                ((NavigationHost)getActivity()).navegacionFragmentos(new LoginFragment());
                break;

            case R.id.btnCancelar:
                ((NavigationHost)getActivity()).navegacionFragmentos(new LoginFragment());
        }

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

}
