package com.zhou.jy.designtest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



public abstract class BaseFragment extends Fragment {
	public Context mContext;
	private ProgressDialog progressDialog;

	public abstract int getContentView();
	public abstract void initView(View view);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.gtotoro_sdk_fragment_base,container, false);
		viewGroup.addView(inflater.inflate(getContentView(),null), 0);
		return viewGroup;
	}
	
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView(view);
	}

	/**
	 * progressDialod弹窗显示
	 * 
	 * @param message
	 *            显示内容地址
	 * @param isCancelable
	 *            “返回键”取消
	 * @param dialogback
	 *            是否监听返回
	 */
	protected void showProgressDialod(String message, boolean isCancelable,
			final OnDismissListener dialogback) {
		if (progressDialog == null) {
			progressDialog = new ProgressDialog(mContext);
		}
		if (dialogback != null) {
			progressDialog.setOnDismissListener(dialogback);
		}

		if (progressDialog.isShowing()) {

			return;

		}

		progressDialog.setCancelable(isCancelable);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.setMessage(message);
		progressDialog.show();

	}

	/**
	 * progressDialod弹窗显示
	 * 
	 * @param message
	 *            显示内容地址
	 * @param isCancelable
	 *            点击弹窗外是否关闭弹窗
	 * 
	 */
	protected void showProgressDialod(String message, boolean isCancelable) {
		showProgressDialod(message, isCancelable, null);
	}

	/**
	 * progressDialod弹窗关闭
	 */
	protected void dismissProgressDialod() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}





	/**
	 * 显示吐司内容
	 * 
	 * @param msg 内容地址
	 */
	protected void showShortToast(String msg) {

		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}


	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (progressDialog != null) {
			progressDialog.dismiss();
		}
		dismissProgressDialod();
	}
	

	public boolean onBackPressed(boolean back) {
		
		
		return back;
	}
}
