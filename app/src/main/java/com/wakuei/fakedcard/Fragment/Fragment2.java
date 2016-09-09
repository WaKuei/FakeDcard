package com.wakuei.fakedcard.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wakuei.fakedcard.AppConnection;
import com.wakuei.fakedcard.Listview.DcardAdapter;
import com.wakuei.fakedcard.Listview.DcardItem;
import com.wakuei.fakedcard.R;
import com.wakuei.fakedcard.Web_View;
import com.wakuei.fakedcard.volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/8/5/005.
 */
public class Fragment2 extends Fragment {
    private PullToRefreshListView mPullList;
    private static final String TAG = Fragment2.class.getSimpleName();
    private String url_old ;
    private String url_new ;
    private List<DcardItem> dcardItems = new ArrayList<DcardItem>();
    private ListView lv;
    private DcardAdapter adapter;
    private DcardItem ditem;
    public String lastid = "";
    private static int type = 0;

    public static void getType(int type){
        Fragment2.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag2view = inflater.inflate(R.layout.frag2,container,false);
//        url_old = "https://www.dcard.tw/_api/posts?popular=true";
//        url_new = "https://www.dcard.tw/_api/posts?popular=true&before=";
        dcardItems.clear();
        listdata2(frag2view);

        return frag2view;

    }
    private void listdata2(View view){
        mPullList = (PullToRefreshListView)view.findViewById(R.id.Lptrlv);
        adapter = new DcardAdapter(getActivity(), dcardItems);

        JSONParse1(AppConnection.AllNewUrl[type]);
        setEventListener();
        initData();

        mPullList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                DcardItem d = (DcardItem)adapterView.getItemAtPosition(i);
                String dforumAlias = d.getForumAlias();
                String did = d.getId();
                String nextUrl = "https://www.dcard.tw/f/"+dforumAlias+"/p/"+did;
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(), Web_View.class);
                Bundle bundle = new Bundle();
                bundle.putString("Url",nextUrl);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    private void JSONParse1(String url){
        JsonArrayRequest itemReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        ditem = new DcardItem();
                        lastid = jsonObject.getString("id");
                        ditem.setTitle(jsonObject.getString("title"));
                        ditem.setExcerpt(jsonObject.getString("excerpt"));
                        ditem.setId(jsonObject.getString("id"));
                        ditem.setForumAlias(jsonObject.getString("forumAlias"));
                        ditem.setLikeCount(jsonObject.getString("likeCount"));
                        ditem.setCommentCount(jsonObject.getString("commentCount"));
                        ditem.setForumName(jsonObject.getString("forumName"));
                        ditem.setGender(jsonObject.getString("gender"));

                        dcardItems.add(ditem);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG,"Error:"+error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(itemReq);
    }

    private void setEventListener() {
        mPullList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {


            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask().execute();
            }
        });

    }




    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }
        @Override
        protected void onPostExecute(String[] result) {
            if(mPullList.isHeaderShown()){          /////刷新

                dcardItems.clear();
                JSONParse1(AppConnection.AllNewUrl[type]);

            }else if(mPullList.isFooterShown()){       ////加載
                url_new = AppConnection.AllNewUrl[type]+"&before="+lastid;
                JSONParse1(url_new);
            }

            adapter.notifyDataSetChanged();

            // 调用刷新完成
            mPullList.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

    private void initData(){
        mPullList.setMode(PullToRefreshBase.Mode.BOTH);
        mPullList.getLoadingLayoutProxy(false,true).setPullLabel("上拉加載...");
        mPullList.getLoadingLayoutProxy(false,true).setRefreshingLabel("加載ing...");
        mPullList.getLoadingLayoutProxy(false,true).setReleaseLabel("鬆開加載更多...");

        mPullList.getLoadingLayoutProxy(true,false).setPullLabel("下拉刷新...");
        mPullList.getLoadingLayoutProxy(true,false).setRefreshingLabel("刷新ing...");
        mPullList.getLoadingLayoutProxy(true,false).setReleaseLabel("鬆開刷新...");

        mPullList.setAdapter(adapter);

    }
    public void reload(){
        adapter.notifyDataSetChanged();
    }


}
