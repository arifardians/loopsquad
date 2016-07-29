package com.loopsquad.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopsquad.activity.MainActivity;
import com.loopsquad.activity.R;

/**
 * Created by Ardians-PC on 7/13/2016.
 */
public class TutorialFragment extends Fragment {

    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vResult = inflater.inflate(R.layout.fragment_tutorial, container, false);
        imageView = (ImageView) vResult.findViewById(R.id.f_tutorial_image);

        int imageId = getArguments().getInt("image_id");
        boolean isLast = getArguments().getBoolean("is_last");
        imageView.setImageResource(imageId);

        if (isLast){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(getActivity(), "last page clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }
        return vResult;
    }
}
