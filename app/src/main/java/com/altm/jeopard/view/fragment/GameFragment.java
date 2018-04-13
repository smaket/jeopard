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
import com.altm.jeopard.model.Clues;
import com.altm.jeopard.model.Player;
import com.altm.jeopard.presenter.AJPresenterImpl;
import com.altm.jeopard.presenter.IAJPresenter;
import com.altm.jeopard.view.adaptor.CategoryAdaptor;
import com.altm.jeopard.view.adaptor.PlayerAdaptor;
import com.altm.jeopard.view.api.IRegisterView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameFragment extends Fragment implements IRegisterView {

    @BindView(R.id.recyler_box)
    RecyclerView mGameBox;
    AJPresenterImpl presenter ;
    private CategoryAdaptor mCategoryAdaptor;
    private ArrayList<Category> mRecyclerCategoryList = new ArrayList<Category>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = new AJPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View lView = inflater.inflate(R.layout.game_recycl, container, false);
        ButterKnife.bind(this,lView);
        prepareRecyclerView();
        return lView;
    }

    private void prepareRecyclerView() {
        mCategoryAdaptor = new CategoryAdaptor(getActivity() ,mRecyclerCategoryList );

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);




//        mGameBox.setLayoutManager(wmLayout);

        mGameBox.setAdapter(mCategoryAdaptor);
        mGameBox.setNestedScrollingEnabled(true);
        mGameBox.setHasFixedSize(true);



    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getClues(presenter);
    }

    @Override
    public void notifyDateChange(Clues aClues) {

    }
}
