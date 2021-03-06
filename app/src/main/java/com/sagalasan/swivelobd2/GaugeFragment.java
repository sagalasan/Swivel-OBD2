package com.sagalasan.swivelobd2;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.sagalasan.swivelobd2.view.DisplayView;
import com.sagalasan.swivelobd2.view.GaugeView;

import java.lang.reflect.GenericArrayType;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GaugeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GaugeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GaugeFragment extends Fragment
{
  private static final String TAG = GaugeFragment.class.getName();
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  private List<GaugeView> gaugeViews;

  private static final int PADDING = 4;

  private int numRows = 3;
  private int numCols = 2;

  public GaugeFragment()
  {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment GaugeFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static GaugeFragment newInstance(String param1, String param2)
  {
    GaugeFragment fragment = new GaugeFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  public static GaugeFragment newInstance()
  {
    return new GaugeFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    if (getArguments() != null)
    {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState)
  {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_gauge, container, false);

    int viewWidth = container.getWidth();
    int viewHeight = container.getHeight();

    Log.d(TAG, "viewWidth " + viewWidth + " viewHeight " + viewHeight);

    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gauge_container);
    linearLayout.setLayoutParams(new FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT));

    linearLayout.removeAllViews();

    linearLayout.setPadding(PADDING, PADDING, PADDING, PADDING);

    LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0);
    rowParams.weight = 1;

    for(int i = 0; i < numRows; i++)
    {
      LinearLayout rowLayout = new LinearLayout(getContext());
      rowLayout.setLayoutParams(new FrameLayout.LayoutParams(
              FrameLayout.LayoutParams.MATCH_PARENT,
              FrameLayout.LayoutParams.WRAP_CONTENT));

      rowLayout.setOrientation(LinearLayout.HORIZONTAL);
      LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
              LinearLayout.LayoutParams.MATCH_PARENT);
      params.weight = 1;
      for(int j = 0; j < numCols; j++)
      {
        LinearLayout containerLayout = new LinearLayout(getContext());
        containerLayout.setPadding(PADDING, PADDING, PADDING, PADDING);
        containerLayout.setGravity(Gravity.CENTER);
        DisplayView displayView = new DisplayView(getContext());
        containerLayout.addView(displayView);
        rowLayout.addView(containerLayout, params);
      }
      linearLayout.addView(rowLayout, rowParams);
    }

    return view;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri)
  {
    if (mListener != null)
    {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context)
  {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener)
    {
      mListener = (OnFragmentInteractionListener) context;
    } else
    {
      //throw new RuntimeException(context.toString()
      //+ " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach()
  {
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
  public interface OnFragmentInteractionListener
  {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
