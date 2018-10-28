package com.example.xinyuxinyuan.view.fragment.wode.detailed;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.model.bean.GiftConterBean;
import com.example.xinyuxinyuan.contract.my.giftconter.GiftConterContract;
import com.example.xinyuxinyuan.presenter.my.giftconter.GiftConterPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedFragment extends BaseFragment implements GiftConterContract.DetailedContractView {
    private ListView giftFragment_gift;
    private ImageView giftFragment__NoDataImg;
    private TextView giftFragment__NoDataTv;
    private GiftConterPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gift;
    }

    @Override
    protected void init(View view) {


        giftFragment_gift = view.findViewById(R.id.giftFragment_gift);
        giftFragment__NoDataTv = view.findViewById(R.id.giftFragment__NoDataTv);
        giftFragment__NoDataImg = view.findViewById(R.id.giftFragment__NoDataImg);


    }

    @Override
    protected void loadData() {
        presenter = new GiftConterPresenter(this);
        presenter.loadGift(LoginShareUtils.getUserMessage(getContext(), "id"), "2");
    }

    @Override
    public void showGiftDetailed(GiftConterBean giftConterBean) {

        if (giftConterBean.getData().getSize() == 0) {
            giftFragment_gift.setVisibility(View.GONE);
            giftFragment__NoDataTv.setVisibility(View.VISIBLE);
            giftFragment__NoDataImg.setVisibility(View.VISIBLE);
        } else {
            List<?> list = giftConterBean.getData().getList();
            giftFragment_gift.setVisibility(View.VISIBLE);
            giftFragment__NoDataTv.setVisibility(View.GONE);
            giftFragment__NoDataImg.setVisibility(View.GONE);
        }
    }
}
