package com.events.hub.swahilipot.swahilipothub;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartupsFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog progressDialog;
    private ListView listView;
    ImageView imageView;

    //Keys
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_EMAIL = "email";
    static final String KEY_WEBSITE = "website";
    static final String KEY_THUMB_URL = "avatar";
    static final String KEY_FOUNDER = "c1";

    // JSON data url
    private static String Jsonurl = "http://members.swahilipothub.co.ke/startups.json";
    ArrayList<HashMap<String, String>> contactJsonList;


    public StartupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_startups, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview);
        // setting image resource from drawable
        imageView = (ImageView) rootView.findViewById(R.id.avatar);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactJsonList = new ArrayList<>();
        new GetStartups().execute();
    }
    private class GetStartups extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading startups...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler httpHandler = new HttpHandler();

            // request to json data url and getting response
            String jsonString = httpHandler.makeServiceCall(Jsonurl);
            Log.e(TAG, "Response from url: " + jsonString);
            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    // Getting JSON Array node
                    JSONArray contacts = jsonObject.getJSONArray("startups");

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String web = c.getString("website");
                        String avatar = c.getString("avatar");

                        // Founders
                        JSONObject founders = c.getJSONObject("founders");
                        String c1 = founders.getString("c1");
                        String c2 = founders.getString("c2");
                        String c3 = founders.getString("c3");
                        String c4 = founders.getString("c4");

                        // tmp hash map for single Startup
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put(KEY_ID, id);
                        contact.put(KEY_NAME, name);
                        contact.put(KEY_EMAIL, email);
                        contact.put(KEY_FOUNDER, c1);
                        contact.put(KEY_WEBSITE, web);
                        contact.put(KEY_THUMB_URL, avatar);

                        // adding Startups to contact list
                        contactJsonList.add(contact);




                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Could not get json from server.");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Could not get json from server.",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    getActivity(), contactJsonList,
                    R.layout.list_startups, new String[]{KEY_NAME,KEY_EMAIL,
                    KEY_WEBSITE,KEY_THUMB_URL}, new int[]{
                    R.id.name,R.id.email, R.id.web, R.id.avatar});

//            Glide.with(getActivity()).load(KEY_THUMB_URL).into(imageView);
            listView.setAdapter(adapter);
        }

    }

    }
