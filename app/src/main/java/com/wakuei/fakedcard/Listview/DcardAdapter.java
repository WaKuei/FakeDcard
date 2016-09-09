package com.wakuei.fakedcard.Listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wakuei.fakedcard.R;

import java.util.List;

/**
 * Created by user on 2016/7/27/027.
 */
public class DcardAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<DcardItem> Ditem;

    public DcardAdapter(Activity activity, List<DcardItem> Ditem){
        this.activity = activity;
        this.Ditem = Ditem;
    }

    @Override
    public int getCount() {return Ditem.size();}

    @Override
    public Object getItem(int i) {return Ditem.get(i);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(inflater == null)
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
            view = inflater.inflate(R.layout.list_item,viewGroup,false);
        TextView title = (TextView)view.findViewById(R.id.Ltitle);
        TextView excerpt = (TextView)view.findViewById(R.id.Lexcerpt);
        TextView likeCount = (TextView)view.findViewById(R.id.LlikeCount);
        TextView commentCount = (TextView)view.findViewById(R.id.LcommentCount);
        TextView forumName = (TextView)view.findViewById(R.id.LforumName);
        ImageView image = (ImageView)view.findViewById(R.id.Lgender);
        //TextView id = (TextView)view.findViewById(R.id.Lid); //只取值 不須show出

        DcardItem m = Ditem.get(position);

        title.setText(m.getTitle());
        excerpt.setText(m.getExcerpt());
        likeCount.setText(m.getLikeCount());
        commentCount.setText(m.getCommentCount());
        forumName.setText(m.getForumName());

        String gender = m.getGender();
        String genderF = "F";
        if(gender.equals(genderF)){
            image.setImageResource(R.drawable.girl);
        }
        else{
            image.setImageResource(R.drawable.boy);
        }

        return view;
    }
}
