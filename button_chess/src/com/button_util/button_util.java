package com.button_util;

import java.util.HashMap;

import com.button_chess.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.Button;

public class button_util {
	public static void init_button(HashMap<Integer, Button> button_map, HashMap<Integer,Drawable> imag_map,OnClickListener listener){
		Button bt=null;
		for(int i=0;i<button_map.size();i++){
			bt=button_map.get(i+1);
			bt.setOnClickListener(listener);
			bt.setBackgroundDrawable(imag_map.get(i));
		}

	}
	
	
	/**
	 * 	get imag from resourses and add them to a map
	 * @param r
	 * 	activity resourses
	 * @return
	 * 	a map include buttons' backimag ordered by buttons' id
	 */
	public static HashMap<Integer,Drawable> init_resourcemap(Resources r){
		HashMap<Integer,Drawable> resourse_map=new HashMap<Integer, Drawable>();
		/**
		 * version 0 
		 * to b continue: 按钮和图片的对应关系从配置文件中读取而不是一个一个改
		 */
		resourse_map.put(1, r.getDrawable(R.drawable.a));
		resourse_map.put(2, r.getDrawable(R.drawable.b));
		resourse_map.put(3, r.getDrawable(R.drawable.c));
		resourse_map.put(4, r.getDrawable(R.drawable.d));
		resourse_map.put(5, r.getDrawable(R.drawable.e));
		resourse_map.put(6, r.getDrawable(R.drawable.f));
		resourse_map.put(7, r.getDrawable(R.drawable.g));
		resourse_map.put(8, r.getDrawable(R.drawable.h));
		resourse_map.put(9, r.getDrawable(R.drawable.i));
		resourse_map.put(10, r.getDrawable(R.drawable.j));
		resourse_map.put(11, r.getDrawable(R.drawable.k));
		resourse_map.put(12, r.getDrawable(R.drawable.l));
		resourse_map.put(13, r.getDrawable(R.drawable.m));
		resourse_map.put(14, r.getDrawable(R.drawable.n));
		resourse_map.put(15, r.getDrawable(R.drawable.o));
		resourse_map.put(16, r.getDrawable(R.drawable.p));
		resourse_map.put(17, r.getDrawable(R.drawable.q));
		resourse_map.put(18, r.getDrawable(R.drawable.r));
		resourse_map.put(19, r.getDrawable(R.drawable.s));
		resourse_map.put(20, r.getDrawable(R.drawable.t));
		resourse_map.put(21, r.getDrawable(R.drawable.u));
		resourse_map.put(22, r.getDrawable(R.drawable.v));
		resourse_map.put(23, r.getDrawable(R.drawable.w));
		resourse_map.put(24, r.getDrawable(R.drawable.x));
		resourse_map.put(25, r.getDrawable(R.drawable.y));
		resourse_map.put(26, r.getDrawable(R.drawable.z));
		resourse_map.put(27, r.getDrawable(R.drawable.a));
		resourse_map.put(28, r.getDrawable(R.drawable.b));
		resourse_map.put(29, r.getDrawable(R.drawable.c));
		resourse_map.put(30, r.getDrawable(R.drawable.d));
		resourse_map.put(31, r.getDrawable(R.drawable.e));
		resourse_map.put(32, r.getDrawable(R.drawable.f));
		resourse_map.put(33, r.getDrawable(R.drawable.g));
		resourse_map.put(34, r.getDrawable(R.drawable.h));
		resourse_map.put(35, r.getDrawable(R.drawable.i));
		resourse_map.put(36, r.getDrawable(R.drawable.j));
		resourse_map.put(37, r.getDrawable(R.drawable.k));
		resourse_map.put(38, r.getDrawable(R.drawable.l));
		resourse_map.put(39, r.getDrawable(R.drawable.m));
		resourse_map.put(40, r.getDrawable(R.drawable.n));
		return resourse_map;
		
	}
}
