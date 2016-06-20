/*
 The MIT License (MIT)

 Copyright (c) 2016 Bill Femmer

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package com.bfemmer.portdawgtoolkit;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RadarChart chart;

    private OnFragmentInteractionListener mListener;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chart = (RadarChart) getView().findViewById(R.id.chart);


        RadarData radarData = getRadarData();
        chart.setData(radarData);
        chart.getYAxis().setDrawLabels(false);
        chart.setDescription("Readiness");
        chart.animateXY(2000, 2000);
        chart.invalidate();

//        BarData data = new BarData(getXAxisValues(), getDataSet());
//        chart.setData(data);
//        chart.setDescription("Readiness");
//        chart.animateXY(2000, 2000);
//        chart.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        chart = null;
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
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private RadarData getRadarData() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("F2F");
        labels.add("EPR");
        labels.add("IMR");
        labels.add("TFAT");
        labels.add("UGR");
        labels.add("UOO");
        labels.add("VEH");
        labels.add("483");

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(80, 0));
        entries.add(new Entry(100, 1));
        entries.add(new Entry(100, 2));
        entries.add(new Entry(100, 3));
        entries.add(new Entry(100, 4));
        entries.add(new Entry(100, 5));
        entries.add(new Entry(20, 6));
        entries.add(new Entry(60, 7));

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(60, 0));
        entries2.add(new Entry(100, 1));
        entries2.add(new Entry(80, 2));
        entries2.add(new Entry(100, 3));
        entries2.add(new Entry(100, 4));
        entries2.add(new Entry(60, 5));
        entries2.add(new Entry(100, 6));
        entries2.add(new Entry(0, 7));

        ArrayList<Entry> entries3 = new ArrayList<>();
        entries3.add(new Entry(100, 0));
        entries3.add(new Entry(80, 1));
        entries3.add(new Entry(80, 2));
        entries3.add(new Entry(80, 3));
        entries3.add(new Entry(80, 4));
        entries3.add(new Entry(60, 5));
        entries3.add(new Entry(100, 6));
        entries3.add(new Entry(50, 7));

        ArrayList<Entry> entries4 = new ArrayList<>();
        entries4.add(new Entry(70, 0));
        entries4.add(new Entry(85, 1));
        entries4.add(new Entry(85, 2));
        entries4.add(new Entry(85, 3));
        entries4.add(new Entry(100, 4));
        entries4.add(new Entry(100, 5));
        entries4.add(new Entry(75, 6));
        entries4.add(new Entry(75, 7));

        ArrayList<Entry> entries5 = new ArrayList<>();
        entries5.add(new Entry(65, 0));
        entries5.add(new Entry(65, 1));
        entries5.add(new Entry(65, 2));
        entries5.add(new Entry(65, 3));
        entries5.add(new Entry(65, 4));
        entries5.add(new Entry(65, 5));
        entries5.add(new Entry(65, 6));
        entries5.add(new Entry(65, 7));

        ArrayList<Entry> entries6 = new ArrayList<>();
        entries6.add(new Entry(25, 0));
        entries6.add(new Entry(55, 1));
        entries6.add(new Entry(25, 2));
        entries6.add(new Entry(55, 3));
        entries6.add(new Entry(25, 4));
        entries6.add(new Entry(55, 5));
        entries6.add(new Entry(25, 6));
        entries6.add(new Entry(55, 7));

        ArrayList<Entry> entries7 = new ArrayList<>();
        entries7.add(new Entry(30, 0));
        entries7.add(new Entry(30, 1));
        entries7.add(new Entry(30, 2));
        entries7.add(new Entry(30, 3));
        entries7.add(new Entry(30, 4));
        entries7.add(new Entry(30, 5));
        entries7.add(new Entry(30, 6));
        entries7.add(new Entry(30, 7));

//        ArrayList<Entry> entries = new ArrayList<>();
//        entries.add(new Entry(0.8f, 0));
//        entries.add(new Entry(1f, 1));
//        entries.add(new Entry(1f, 2));
//        entries.add(new Entry(1f, 3));
//        entries.add(new Entry(1f, 4));
//        entries.add(new Entry(1f, 5));
//        entries.add(new Entry(0.2f, 6));
//        entries.add(new Entry(0.6f, 7));
//
//        ArrayList<Entry> entries2 = new ArrayList<>();
//        entries2.add(new Entry(0.6f, 0));
//        entries2.add(new Entry(1f, 1));
//        entries2.add(new Entry(0.8f, 2));
//        entries2.add(new Entry(1f, 3));
//        entries2.add(new Entry(1f, 4));
//        entries2.add(new Entry(0.6f, 5));
//        entries2.add(new Entry(1f, 6));
//        entries2.add(new Entry(0f, 7));
//
//        ArrayList<Entry> entries3 = new ArrayList<>();
//        entries3.add(new Entry(1f, 0));
//        entries3.add(new Entry(0.8f, 1));
//        entries3.add(new Entry(0.8f, 2));
//        entries3.add(new Entry(0.8f, 3));
//        entries3.add(new Entry(0.8f, 4));
//        entries3.add(new Entry(0.6f, 5));
//        entries3.add(new Entry(1f, 6));
//        entries3.add(new Entry(0.5f, 7));

        RadarDataSet radardataset = new RadarDataSet(entries, "Fleet");
        RadarDataSet cargoradardataset = new RadarDataSet(entries2, "Cargo");
        RadarDataSet rampradardataset = new RadarDataSet(entries3, "Ramp");
        RadarDataSet paxradardataset = new RadarDataSet(entries4, "Pax");
        RadarDataSet atocradardataset = new RadarDataSet(entries5, "ATOC");
        RadarDataSet lpradardataset = new RadarDataSet(entries6, "L/P");
        RadarDataSet shradardataset = new RadarDataSet(entries7, "S/H");

        radardataset.setColor(Color.BLUE);
        cargoradardataset.setColor(Color.RED);
        rampradardataset.setColor(Color.GREEN);
        paxradardataset.setColor(Color.YELLOW);
        atocradardataset.setColor(Color.CYAN);
        lpradardataset.setColor(Color.MAGENTA);
        shradardataset.setColor(Color.DKGRAY);

        radardataset.setDrawFilled(false);
        cargoradardataset.setDrawFilled(false);
        rampradardataset.setDrawFilled(false);
        paxradardataset.setDrawFilled(false);
        atocradardataset.setDrawFilled(false);
        lpradardataset.setDrawFilled(false);
        shradardataset.setDrawFilled(false);

        List<RadarDataSet> radarDataSets = new ArrayList<>();
        radarDataSets.add(radardataset);
        radarDataSets.add(cargoradardataset);
        radarDataSets.add(rampradardataset);
        radarDataSets.add(paxradardataset);
        radarDataSets.add(atocradardataset);
        radarDataSets.add(lpradardataset);
        radarDataSets.add(shradardataset);

        RadarData data = new RadarData(labels, radarDataSets);

        return data;
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }
}
