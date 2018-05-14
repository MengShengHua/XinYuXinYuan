package com.example.xinyuxinyuan.view.fragment.zuoye.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.bean.DianZanBean;
import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.contract.bean.ZuoYeBean;
import com.example.xinyuxinyuan.contract.home.DianZan;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
import com.example.xinyuxinyuan.presenter.dianzan.DianZanPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.QuXiaoDianZanPresenter;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing.ZuoYeXiangQingActivity;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.fragment.mingshi.adpater.TuiJianZuoYe_Adpater;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/6.
 */

public class TouTingAdpater extends RecyclerView.Adapter<TouTingAdpater.Hodler> implements View.OnClickListener, DianZan.View, QuXiaoDianZan.View {
    Context context;
    List<ZuoYeBean.DataBean.ListBean> mList;
    private final DianZanPresenter dianZanPresenter;
    private final QuXiaoDianZanPresenter quXiaoDianZanPresenter;
    private boolean DianZanTag = false;
    private PopupWindow popupWindow;
    private Button jindou_dismiss;
    private TextView jindou_weixin;
    private TextView jindou_zhifubao;

    public TouTingAdpater(Context context, List<ZuoYeBean.DataBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;
        dianZanPresenter = new DianZanPresenter(this);
        quXiaoDianZanPresenter = new QuXiaoDianZanPresenter(this);
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuijian_zuoye_item_layout, parent, false);
        Hodler holder = new Hodler(inflate);
        inflate.setOnClickListener(this);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jindou_popup, null);
        jindou_zhifubao = view.findViewById(R.id.jindou_zhifubao);
        jindou_zhifubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.mainThread("支付宝功能开发中", 0);
            }
        });
        jindou_weixin = view.findViewById(R.id.jindou_weixin);
        jindou_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.mainThread("微信功能开发中", 0);
            }
        });
        jindou_dismiss = view.findViewById(R.id.jindou_dismiss);
        jindou_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Hodler holder, final int position) {

        if (mList.get(position).getTUserType() == 0) {
            holder.tuijian_zuoye_item_teacher_layout.setVisibility(View.GONE);
        } else {
            holder.tuijian_zuoye_item_teacher_layout.setVisibility(View.VISIBLE);
        }

        holder.tuijian_zuoye_item_userName.setText(mList.get(position).getNickname());
        holder.tuijian_zuoye_item_data.setText(DataUtils.getDateToString(mList.get(position).getCreateDate()));
        holder.tuijian_zuoye_item_from.setText(mList.get(position).getSource());
        holder.tuijian_zuoye_item_content.setText(mList.get(position).getContent());
        holder.tuijian_zuoye_item_teacher_price.setText("1.0元偷看");
        holder.tuijian_zuoye_item_teachername.setText((String) mList.get(position).getTRealname());
        holder.home_masterwork_listitem_teacherDaren.setText((String) mList.get(position).getTIntro());
        Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.tuijian_zuoye_item_image);
        Glide.with(context).load(mList.get(position).getPhoto()).transform(new GlideCircleTransform(context)).into(holder.tuijian_zuoye_item_userPhoto);
        Glide.with(context).load(mList.get(position).getTPhoto()).transform(new GlideCircleTransform(context)).into(holder.tuijian_zuoye_item_teacherimg);
        holder.tuijian_zuoye_item_dianzan.setText("" + mList.get(position).getPraiseNum());
        holder.tuijian_zuoye_item_shang.setText("" + mList.get(position).getGiftNum());
        //评论的点击事件
        holder.tuijian_zuoye_item_pinlun.setText("" + mList.get(position).getCommentNum());
        holder.home_masterwork_list_item_reply_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin();
                holder.tuijian_zuoye_item_pinlun.setChecked(true);
            }
        });
        holder.tuijian_zuoye_item_pinlun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(context, ZuoYeXiangQingActivity.class);
                    intent.putExtra("id", mList.get(position).getId());
                    context.startActivity(intent);
                }
            }
        });
        //这是点赞的点击事件
        int praiseNum = mList.get(position).getPraiseNum();
        holder.tuijian_zuoye_item_dianzan.setText("" + praiseNum);
        if (mList.get(position).getIsPraise() == 0) {
            holder.tuijian_zuoye_item_dianzan.setChecked(false);
        } else if (mList.get(position).getIsPraise() == 1) {
            holder.tuijian_zuoye_item_dianzan.setChecked(true);
        }

        holder.tuijian_zuoye_item_dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin();
                if (holder.tuijian_zuoye_item_dianzan.isChecked()) {
                    holder.tuijian_zuoye_item_dianzan.setText("" + (mList.get(position).getPraiseNum() + 1));
                    dianZanPresenter.loadDianZanData(mList.get(position).getTUserId(), mList.get(position).getId(),ShareUtils.getLoginUserId(), "学生作业");
                } else {
                    quXiaoDianZanPresenter.loadQuXiaoDianZan(mList.get(position).getTUserId(),mList.get(position).getId(),ShareUtils.getLoginUserId(), "学生作业");
                    holder.tuijian_zuoye_item_dianzan.setText("" + (Integer.parseInt(holder.tuijian_zuoye_item_dianzan.getText().toString())-1));
                }
            }
        });
//        holder.tuijian_zuoye_item_dianzan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked == true) {
//                    DianZanTag = false;
//                    holder.tuijian_zuoye_item_dianzan.setText("" + (mList.get(position).getPraiseNum() + 1));
//                } else {
//                    DianZanTag = true;
//                    holder.tuijian_zuoye_item_dianzan.setText("" + mList.get(position).getPraiseNum());
//                }
//            }
//        });


        //这是打赏的点击事件
        holder.tuijian_zuoye_item_shang.setText("" + mList.get(position).getGiftNum());
        holder.tuijian_zuoye_item_shang_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ZuoYeXiangQingActivity.class);
                intent.putExtra("id", mList.get(position).getId());
                context.startActivity(intent);
            }
        });


        //这是分享的点击事件
        holder.tuijian_zuoye_item_fenxiang_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb web = new UMWeb(mList.get(position).getPath());
                web.setTitle(mList.get(position).getNickname());//标题
                UMImage umImage = new UMImage(context, mList.get(position).getCoverImg());
                web.setThumb(umImage);
                web.setDescription(mList.get(position).getContent());//描述
                new ShareAction(App.context)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .withMedia(web)
                        .open();
            }
        });

        holder.tuijian_zuoye_item_teacher_price_group.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(holder.tuijian_zuoye_item_dianzan, Gravity.BOTTOM, 0, 0);
                popupWindow.setAnimationStyle(R.style.PopupAnimation);
                popupWindow.setClippingEnabled(true);
            }
        });


        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public void showDianZanData(DianZanBean dianZanBean) {
        DianZanTag = true;
    }

    @Override
    public void showQuXiaoDianZanData(QuXiaoDianZanBean quXiaoDianZan) {
        DianZanTag = false;
    }

    public class Hodler extends RecyclerView.ViewHolder {
        private final TextView tuijian_zuoye_item_userName;
        private final ImageView tuijian_zuoye_item_userPhoto;
        private final ImageView tuijian_zuoye_item_image;
        private final TextView tuijian_zuoye_item_content;
        private final TextView tuijian_zuoye_item_content_yincang;
        private final TextView tuijian_zuoye_item_data;
        private final CheckBox tuijian_zuoye_item_dianzan;
        private final ImageView tuijian_zuoye_item_fenxiang;
        private final TextView tuijian_zuoye_item_from;
        private final CheckBox tuijian_zuoye_item_pinlun;
        private final CheckBox tuijian_zuoye_item_shang;
        private final TextView tuijian_zuoye_item_teacher_price;
        private final ImageView tuijian_zuoye_item_teacherimg;
        private final TextView tuijian_zuoye_item_teachername;
        private final TextView home_masterwork_listitem_teacherDaren;
        private final RelativeLayout tuijian_zuoye_item_teacher_layout;
        private final LinearLayout tuijian_zuoye_item_fenxiang_group;
        private final LinearLayout tuijian_zuoye_item_dianzan_group;
        private final LinearLayout tuijian_zuoye_item_shang_group;
        private final LinearLayout tuijian_zuoye_item_teacher_price_group;
        private final LinearLayout home_masterwork_list_item_reply_group;

        public Hodler(View itemView) {
            super(itemView);
            tuijian_zuoye_item_userName = itemView.findViewById(R.id.tuijian_zuoye_item_userName);
            tuijian_zuoye_item_userPhoto = itemView.findViewById(R.id.tuijian_zuoye_item_userPhoto);
            tuijian_zuoye_item_image = itemView.findViewById(R.id.tuijian_zuoye_item_image);
            tuijian_zuoye_item_content = itemView.findViewById(R.id.tuijian_zuoye_item_Content);
            tuijian_zuoye_item_content_yincang = itemView.findViewById(R.id.tuijian_zuoye_item_Content_yincang);
            tuijian_zuoye_item_data = itemView.findViewById(R.id.tuijian_zuoye_item_Data);
            tuijian_zuoye_item_dianzan = itemView.findViewById(R.id.tuijian_zuoye_item_dianzan);
            tuijian_zuoye_item_fenxiang = itemView.findViewById(R.id.tuijian_zuoye_item_fenxiang);
            tuijian_zuoye_item_from = itemView.findViewById(R.id.tuijian_zuoye_item_From);
            tuijian_zuoye_item_pinlun = itemView.findViewById(R.id.tuijian_zuoye_item_pinlun);
            tuijian_zuoye_item_shang = itemView.findViewById(R.id.tuijian_zuoye_item_shang);
            tuijian_zuoye_item_teacher_price = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_price);
            tuijian_zuoye_item_teacherimg = itemView.findViewById(R.id.tuijian_zuoye_item_teacherimg);
            tuijian_zuoye_item_teachername = itemView.findViewById(R.id.tuijian_zuoye_item_teachername);
            home_masterwork_listitem_teacherDaren = itemView.findViewById(R.id.home_masterwork_listitem_teacherDaren);
            tuijian_zuoye_item_teacher_layout = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_layout);
            home_masterwork_list_item_reply_group = itemView.findViewById(R.id.home_masterwork_list_item_reply_group);
            tuijian_zuoye_item_fenxiang_group = itemView.findViewById(R.id.tuijian_zuoye_item_fenxiang_group);
            tuijian_zuoye_item_dianzan_group = itemView.findViewById(R.id.tuijian_zuoye_item_dianzan_group);
            tuijian_zuoye_item_shang_group = itemView.findViewById(R.id.tuijian_zuoye_item_shang_group);
            tuijian_zuoye_item_teacher_price_group = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_price_group);
        }
    }

    private void isLogin() {
        if (ShareUtils.getLoginUserId() == 0) {
            Toast.makeText(context, "请您先去登录", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            return;
        }
    }


    public interface MyFace {
        void setItemClick(View view, int position);
    }

    private TuiJianZuoYe_Adpater.MyFace myFace;

    public void getItemClick(TuiJianZuoYe_Adpater.MyFace myFace) {
        this.myFace = myFace;
    }

    @Override
    public void onClick(View view) {
        if (myFace != null) {
            myFace.setItemClick(view, (Integer) view.getTag());
        }
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();

        }
    };
}
