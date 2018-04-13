package com.altm.jeopardygame.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.altm.jeopard.R;
import com.altm.jeopard.model.Category;
import com.altm.jeopard.model.Player;
import com.altm.jeopard.view.adaptor.CategoryAdaptor;
import com.altm.jeopard.view.adaptor.PlayerAdaptor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerFragment extends Fragment{


    @BindView(R.id.recycler_view_players)
    RecyclerView mPlayer;

    private CategoryAdaptor mCategoryAdaptor;
    private ArrayList<Category> mRecyclerCategoryList = new ArrayList<Category>();
    private PlayerAdaptor mPlayerAdaptor;
    private ArrayList<Player> mRecyPlayerList = new ArrayList<Player>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        Player player1 = new Player();
        player1.setName("Bikash");
        player1.setPlayer("Player1");
        player1.setScore(500);

        Player player2 = new Player();
        player2.setName("Nilesh");
        player2.setPlayer("Player2");
        player2.setScore(1000);

        Player player3 = new Player();
        player1.setName("Laxmi");
        player1.setPlayer("Player3");
        player1.setScore(800);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View lView = inflater.inflate(R.layout.player_recyl, container, false);
        ButterKnife.bind(this,lView);
        prepareRecyclerView();
        return lView;
    }

    private void prepareRecyclerView() {
        mPlayerAdaptor = new PlayerAdaptor(getActivity(),mRecyPlayerList);
        mCategoryAdaptor = new CategoryAdaptor(getActivity() ,mRecyclerCategoryList );

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);



        mPlayer.setLayoutManager(layoutManager);

        mPlayer.setAdapter(mPlayerAdaptor);
        mPlayer.setNestedScrollingEnabled(true);
        mPlayer.setHasFixedSize(true);



    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
