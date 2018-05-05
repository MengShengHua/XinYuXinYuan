package com.example.xinyuxinyuan.utils.zidingyi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.xinyuxinyuan.R;

public class LoadMoreListView extends ListView implements NestedScrollView.OnScrollChangeListener {

	private View footer;

	private boolean isLoading;

	private OnLoadMore onLoadMore;

	private LayoutInflater inflater;

	private View loadView;

	private Context context;

	private NestedScrollView nestedScrollView;

	public LoadMoreListView(Context context) {
        super(context);
		init(context);
	}

	public LoadMoreListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public LoadMoreListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	@SuppressLint("InflateParams")
	private void init(Context context) {

		this.context = context;

		inflater = LayoutInflater.from(context);
		footer = inflater.inflate(R.layout.load_more_footer, null, false);
		footer.setVisibility(View.GONE);
//		this.addFooterView(footer,null,false);
	}

	public void setLoadMoreListen(OnLoadMore onLoadMore){
		this.onLoadMore = onLoadMore;
	}
	/**
	 * 加载完成调用此方法
	 */
	public void onLoadComplete(){
		if(loadView!=null){
			loadView.setVisibility(View.GONE);
		}
		isLoading = false;

	}


	/**
	 * 最后一条数据调用此方法
	 */
	public void onLoadEnd(){
		isLoading = true;
		if(loadView!=null){
			loadView.setVisibility(View.GONE);
		}
	}

	public void removeFooter() {
		this.removeFooterView(footer);
	}

	@Override
	public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

		if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
			// 底部
			if(!isLoading){
				isLoading=true;
				if(loadView!=null){
					loadView.setVisibility(View.VISIBLE);
					nestedScrollView.post(new Runnable() {
						@Override
						public void run() {

							nestedScrollView.fullScroll(ScrollView.FOCUS_DOWN);
						}
					});

				}

				Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(onLoadMore!=null){
							onLoadMore.loadMore();
						}
					}
				}, 500);

			}
		}

	}


	public void setNestedScrollView(NestedScrollView nestedScrollView,View loadView) {
		this.loadView = loadView;
		this.nestedScrollView = nestedScrollView;
		loadView.setVisibility(GONE);
		this.nestedScrollView.setOnScrollChangeListener(this);
	}

	public interface OnLoadMore{
		void loadMore();
	}


//	public  void setListViewHeightBasedOnChildren(ListView listView) {
//		ListAdapter listAdapter = listView.getAdapter();
//		ViewGroup.LayoutParams params = listView.getLayoutParams();
//		if (listAdapter == null) {
//			// pre-condition
//			return;
//		}
//		int totalHeight = 0;
//		View view;
//		for (int i = 0; i < listAdapter.getCount(); i++) {
//			view = listAdapter.getView(i, null, listView);
//			//宽度为屏幕宽度
//
//			int i1 = View.MeasureSpec.makeMeasureSpec(getScreenWidth(context),
//					MeasureSpec.EXACTLY);
//			//根据屏幕宽度计算高度
//			int i2 = View.MeasureSpec.makeMeasureSpec(i1, MeasureSpec.UNSPECIFIED);
//			view.measure(i1, i2);
//			totalHeight += view.getMeasuredHeight();
//
//		}
//		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)) ;
//		listView.setLayoutParams(params);

//	}

//
//	public  int getScreenWidth(Context context){
//		WindowManager manager = (WindowManager) context
//				.getSystemService(Context.WINDOW_SERVICE);
//		Display display = manager.getDefaultDisplay();
//		return display.getWidth();
//	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}