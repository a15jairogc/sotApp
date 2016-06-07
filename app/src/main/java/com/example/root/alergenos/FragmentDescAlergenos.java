package com.example.root.alergenos;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.alergenos.Preferences.AlergenosApplication;
import com.example.root.alergenos.clase.Alergenos;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by jairo on 6/06/16.
 */
public class FragmentDescAlergenos extends Fragment {

    TextView mTextView;
    ImageView mImageView;
    MainActivity mainActivity;
    FragmentAlergeno fragmentAlergeno;
    Alergenos alergenos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_desc_alergenos, container, false);


        ExpandableTextView expTv1 = (ExpandableTextView)view.findViewById(R.id.tvAlergeno);

// IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        //expTv1.setText(getString(R.string.dummy_text1));

            alergenos = getArguments().getParcelable("listaAlergenos");
            mImageView = (ImageView) view.findViewById(R.id.imAlergeno);
            mImageView.setImageResource(AlergenosApplication.helper.getImgDesc());
            expTv1.setText(alergenos.getDescripcion());
           // mTextView.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }


    public static FragmentDescAlergenos newInstance(Alergenos a) {

        Bundle args = new Bundle();
        FragmentDescAlergenos fragment = new FragmentDescAlergenos();
        args.putParcelable("listaAlergenos",a);
        fragment.setArguments(args);

        return fragment;
    }

}
