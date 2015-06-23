package com.example.gam3r.partyrocker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gam3r.partyrocker.util.boayz.SwipeMenu;
import com.example.gam3r.partyrocker.util.boayz.SwipeMenuCreator;
import com.example.gam3r.partyrocker.util.boayz.SwipeMenuItem;
import com.example.gam3r.partyrocker.util.boayz.SwipeMenuListView;
import com.example.gam3r.partyrocker.util.boayz.SwipeMenuListView.OnMenuItemClickListener;
import com.example.gam3r.partyrocker.util.boayz.SwipeMenuListView.OnSwipeListener;
import java.util.ArrayList;
import java.util.List;

//import com.baoyz.swipemenulistview.SwipeMenu;
//import com.baoyz.swipemenulistview.SwipeMenuCreator;
//import com.baoyz.swipemenulistview.SwipeMenuItem;
//import com.baoyz.swipemenulistview.SwipeMenuListView;
//import com.baoyz.swipemenulistview.SwipeMenuListView.OnMenuItemClickListener;
//import com.baoyz.swipemenulistview.SwipeMenuListView.OnSwipeListener;

public class demo extends Activity {

//    private List<ApplicationInfo> mUpcomingSongsList;
    private List<String> mUpcomingSongsList = new ArrayList<String>();
    private List<String> mCurrentSongList = new ArrayList<String>();
    private upcomingSongsAdapter mUpcomingSongsAdapter;
    private currentSongsAdapter mCurrentSongAdapter;
    private Button mChangePreferences;

    private SwipeMenuListView mListView,mCurrentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mUpcomingSongsList.add("Bhula dena");
        mUpcomingSongsList.add("teri yaad");
        mUpcomingSongsList.add("Titanic");
        mUpcomingSongsList.add("askjdklasjlkd");
        mUpcomingSongsList.add("adkjsadkaslk");

        mCurrentSongList.add("Tum hi ho bandu");

//        mUpcomingSongsList = getPackageManager().getInstalledApplications(4);

        initializeVariables();
        mUpcomingSongsAdapter = new upcomingSongsAdapter();
        mCurrentSongAdapter = new currentSongsAdapter();
        mListView.setAdapter(mUpcomingSongsAdapter);
        mCurrentListView.setAdapter(mCurrentSongAdapter);

        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(
//                        getApplicationContext());
//                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
//                        0xCE)));
//                // set item width
//                openItem.setWidth(dp2px(90));
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu
//                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        mListView.setMenuCreator(creator);
        mCurrentListView.setMenuCreator(creator);



        // step 2. listener item click event
        mCurrentListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
//                ApplicationInfo item = mUpcomingSongsList.get(position);
                switch (index) {
//                    case 0:
//                        // open
//                        open(item);
//                        break;
                    case 0:
                        // delete
//					delete(item);
                        System.out.println(position);
                        blurrItem(position, mCurrentSongList, mCurrentListView);
//                        mUpcomingSongsList.remove(position);
                        mCurrentSongAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });

        mListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
//                ApplicationInfo item = mUpcomingSongsList.get(position);
                switch (index) {
//                    case 0:
//                        // open
//                        open(item);
//                        break;
                    case 0:
                        // delete
//					delete(item);
                        blurrItem(position,mUpcomingSongsList,mListView);
//                        mUpcomingSongsList.remove(position);
//                        System.out.println("index::: "+menu.getMenuItem(index));
                        mUpcomingSongsAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });


        mChangePreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mChangePreferenceIntent = new Intent(demo.this,ChangePreference.class);
                startActivity(mChangePreferenceIntent);
            }
        });

        // set SwipeListener
        mListView.setOnSwipeListener(new OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
            }
        });

        // other setting
//		mListView.setCloseInterpolator(new BounceInterpolator());

        // test item long click
//        mListView.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view,
//                                           int position, long id) {
//                Toast.makeText(getApplicationContext(), position + " long click", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

    }

    // This function will gray out the list item at the given position
    private void blurrItem(int position, List<String> list, SwipeMenuListView view) {
        Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
        view.getChildAt(position).setBackgroundColor(Color.GRAY);
//        System.out.println(view.getChildAt(position));
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void initializeVariables(){
        mCurrentListView = (SwipeMenuListView) findViewById(R.id.listView1);
        mListView = (SwipeMenuListView) findViewById(R.id.listView2);
        mChangePreferences = (Button) findViewById(R.id.changePreferences);
    }
    class upcomingSongsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mUpcomingSongsList.size();
        }

        @Override
        public String getItem(int position) {
            return mUpcomingSongsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.item_list_song, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
//            ApplicationInfo item = getItem(position);
            String item = getItem(position);
//            holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
//            holder.tv_name.setText(item.loadLabel(getPackageManager()));
            holder.tv_name.setText(item);
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;

            public ViewHolder(View view) {
//                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.tv_name);
                view.setTag(this);
            }
        }
    }
    class currentSongsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mCurrentSongList.size();
        }

        @Override
        public String getItem(int position) {
            return mCurrentSongList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.item_list_song, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
//            ApplicationInfo item = getItem(position);
            String item = getItem(position);
//            holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
//            holder.tv_name.setText(item.loadLabel(getPackageManager()));
            holder.tv_name.setText(item);
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;

            public ViewHolder(View view) {
//                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.tv_name);
                view.setTag(this);
            }
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
