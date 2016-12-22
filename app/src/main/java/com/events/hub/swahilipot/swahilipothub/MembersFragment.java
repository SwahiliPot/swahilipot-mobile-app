package com.events.hub.swahilipot.swahilipothub;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.events.hub.swahilipot.swahilipothub.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MembersFragment extends Fragment {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static final String url = "http://members.swahilipothub.co.ke/watu.php";
    private ProgressDialog pDialog;
    private List<Member> memberList = new ArrayList<Member>();
    private ListView listView;
    private CustomListAdapter adapter;

    public MembersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_members,null);
        TextView bt = (TextView) rootView.findViewById(R.id.bounties_text);
        listView = (ListView) rootView.findViewById(R.id.list);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new CustomListAdapter(getActivity(), memberList);
        listView.setAdapter(adapter);
        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Fetching Member...");
        pDialog.show();

        //Opens activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent detailActivity = new Intent(getActivity(), MemberDetailsActivity.class);
                        Bundle extras = new Bundle();
                        Member member = new Member();
                        extras.putString("EXTRA_NAME",member.getName());
                        extras.putString("EXTRA_EMAIL",member.getEmail());
                        extras.putString("EXTRA_GENDER",member.getGender());
                        extras.putString("EXTRA_AVATAR",member.getAvatar());
                        extras.putString("EXTRA_WEB",member.getWeb());
                        extras.putString("EXTRA_BIO",member.getBio());
                        extras.putString("EXTRA_CAT",member.getCategory());
                        extras.putString("EXTRA_REG",member.getReg());
                        detailActivity.putExtras(extras);
                        startActivity(detailActivity);
                        break;

                }
            }
        });

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Member member = new Member();
                                member.setName(obj.getString("name"));
                                member.setAvatar(obj.getString("profilePic"));
                                member.setReg(obj.getString("regno"));
                                member.setBounties(obj.getInt("bounties"));
                                member.setEmail(obj.getString("email"));
                                member.setGender(obj.getString("gender"));
                                member.setStatus(obj.getString("status"));
                                member.setBio(obj.getString("bio"));
                                member.setCreatedAt(obj.getString("created"));
                                member.setWeb(obj.getString("website"));

                                // Genre is json array
//                                JSONArray genreArry = obj.getJSONArray("genre");
//                                ArrayList<String> genre = new ArrayList<String>();
//                                for (int j = 0; j < genreArry.length(); j++) {
//                                    genre.add((String) genreArry.get(j));
//                                }

                                member.setCategory(obj.getString("category"));

                                //member.setCategory("category");

                                // adding member to members array
                                memberList.add(member);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
