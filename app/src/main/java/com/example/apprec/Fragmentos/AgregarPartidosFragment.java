package com.example.apprec.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.apprec.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AgregarPartidosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarPartidosFragment extends Fragment implements AdapterView.OnItemSelectedListener {
   private Spinner spLiga;
    private Spinner spLocal;

    String[] ligaSantan = getResources().getStringArray(R.array.ligaSantander);






    public AgregarPartidosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarPartidosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarPartidosFragment newInstance(String param1, String param2) {
        AgregarPartidosFragment fragment = new AgregarPartidosFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_agregar_partidos, container, false);

        spLiga = v.findViewById(R.id.spinnerLigas);
        spLocal = v.findViewById(R.id.spinnerEquipoLocal);

        spLiga.setOnItemSelectedListener(this);


        return  v;
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        if(spLiga.getSelectedItem().equals("Liga Santander")) {
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
