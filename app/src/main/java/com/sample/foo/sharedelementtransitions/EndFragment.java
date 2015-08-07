package com.sample.foo.sharedelementtransitions;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class EndFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String actionTitle = "DUMMY ACTION";
        Bitmap imageBitmap = null;
        String transText = "";
        String transitionName = "";

        if (bundle != null) {
            transitionName = bundle.getString("TRANS_NAME");
            actionTitle = bundle.getString("ACTION");
            imageBitmap = bundle.getParcelable("IMAGE");
            transText = bundle.getString("TRANS_TEXT");
        }

        getActivity().setTitle(actionTitle);
        View view = inflater.inflate(R.layout.fragment_end, container, false);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.findViewById(R.id.listImage).setTransitionName(transitionName);
            view.findViewById(R.id.textView).setTransitionName(transText);
        }

        ((ImageView) view.findViewById(R.id.listImage)).setImageBitmap(imageBitmap);
        ((TextView) view.findViewById(R.id.textView)).setText(actionTitle);

        return view;
    }
}
