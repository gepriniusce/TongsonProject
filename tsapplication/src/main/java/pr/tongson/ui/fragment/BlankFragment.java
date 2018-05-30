package pr.tongson.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pr.tongson.R;
import pr.tongson.ui.adapter.KeyBoardAdapter;

public class BlankFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private TextView mDisplayTv;
    private RecyclerView mKeyboardRcly;
    private KeyBoardAdapter mKeyBoardAdapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDisplayTv = view.findViewById(R.id.tv_display);
        mKeyboardRcly = view.findViewById(R.id.rcy_keyboard);
        mKeyboardRcly.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mKeyBoardAdapter = new KeyBoardAdapter(getActivity());
        mKeyboardRcly.setAdapter(mKeyBoardAdapter);
        mKeyBoardAdapter.setOnItemClickLitener(new KeyBoardAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
