package com.example.nicols.turismo_envigado_maestro_detalle_pto2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nicols.turismo_envigado_maestro_detalle_pto2.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        FragmentManager fragmentmanager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            if (mItem.item_name.equals("Publicidad")){
                Publicidad fragmentpublicidad = new Publicidad();
                fragmentTransaction.replace(android.R.id.content,fragmentpublicidad).commit();
            }else if (mItem.item_name.equals("Hoteles")){
                Hoteles fragmenthoteles = new Hoteles();
                fragmentTransaction.replace(android.R.id.content,fragmenthoteles).commit();
            }else if (mItem.item_name.equals("Bares")){
                Bares fragmentbares = new Bares();
                fragmentTransaction.replace(android.R.id.content,fragmentbares).commit();
            }else if (mItem.item_name.equals("Turismo")){
                Turismo fragmentturismo = new Turismo();
                fragmentTransaction.replace(android.R.id.content,fragmentturismo).commit();
            }else if (mItem.item_name.equals("Demografia")){
                Demografia fragmentdemografia = new Demografia();
                fragmentTransaction.replace(android.R.id.content,fragmentdemografia).commit();
            }else if (mItem.item_name.equals("Acerca de")){
                Acercade fragmentacercade = new Acercade();
                fragmentTransaction.replace(android.R.id.content,fragmentacercade).commit();
            }else if (mItem.item_name.equals("Mapa")){
                Map fragmentMapa = new Map();
                fragmentTransaction.replace(android.R.id.content,fragmentMapa).commit();
            }
        }

        return rootView;
    }
}
