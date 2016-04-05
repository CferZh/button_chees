package com.button_chess;

import java.util.HashMap;
import java.util.Random;

import com.button_chess.R;
import com.button_util.button_util;
import com.string_util.string_util;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private boolean is_started=false;
	private Button tv;
	private int now_pos=1;
	private Button bt;
	private HashMap<Integer,Button> map; 
	private HashMap<Integer,String> button_decription;
	private HashMap<Integer,Drawable> resourse_map;
	private Resources res;
	private Drawable chessman;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(Button)findViewById(R.id.mybutton00);
		res=this.getResources();
		/**
		 * init chessman's icon
		 */
		chessman=res.getDrawable(R.drawable.sz6);
		/**
		 * init resource_map
		 * storage of buttons image 
		 */
		resourse_map=button_util.init_resourcemap(res);
		/**
		 * init location_map
		 * map of the buttons to travel
		 */
		map=new HashMap<Integer, Button>();
		map.put(1, (Button)findViewById(R.id.mybutton71));
		map.put(2, (Button)findViewById(R.id.mybutton72));
		map.put(3, (Button)findViewById(R.id.mybutton73));
		map.put(4, (Button)findViewById(R.id.mybutton74));
		map.put(5, (Button)findViewById(R.id.mybutton75));
		map.put(6, (Button)findViewById(R.id.mybutton76));
		map.put(7, (Button)findViewById(R.id.mybutton77));
		map.put(8, (Button)findViewById(R.id.mybutton78));
		map.put(9, (Button)findViewById(R.id.mybutton79));
		map.put(10, (Button)findViewById(R.id.mybutton69));
		map.put(11, (Button)findViewById(R.id.mybutton59));
		map.put(12, (Button)findViewById(R.id.mybutton49));
		map.put(13, (Button)findViewById(R.id.mybutton39));
		map.put(14, (Button)findViewById(R.id.mybutton3A));
		map.put(15, (Button)findViewById(R.id.mybutton2A));
		map.put(16, (Button)findViewById(R.id.mybutton1A));
		map.put(17, (Button)findViewById(R.id.mybutton19));
		map.put(18, (Button)findViewById(R.id.mybutton18));
		map.put(19, (Button)findViewById(R.id.mybutton17));
		map.put(20, (Button)findViewById(R.id.mybutton16));
		map.put(21, (Button)findViewById(R.id.mybutton15));
		map.put(22, (Button)findViewById(R.id.mybutton14));
		map.put(23, (Button)findViewById(R.id.mybutton13));
		map.put(24, (Button)findViewById(R.id.mybutton12));
		map.put(25, (Button)findViewById(R.id.mybutton11));
		map.put(26, (Button)findViewById(R.id.mybutton21));
		map.put(27, (Button)findViewById(R.id.mybutton31));
		map.put(28, (Button)findViewById(R.id.mybutton41));
		map.put(29, (Button)findViewById(R.id.mybutton51));
		map.put(30, (Button)findViewById(R.id.mybutton52));
		map.put(31, (Button)findViewById(R.id.mybutton53));
		map.put(32, (Button)findViewById(R.id.mybutton54));
		map.put(33, (Button)findViewById(R.id.mybutton55));
		map.put(34, (Button)findViewById(R.id.mybutton56));
		map.put(35, (Button)findViewById(R.id.mybutton57));
		map.put(36, (Button)findViewById(R.id.mybutton47));
		map.put(37, (Button)findViewById(R.id.mybutton37));
		map.put(38, (Button)findViewById(R.id.mybutton36));
		map.put(39, (Button)findViewById(R.id.mybutton35));
		map.put(40, (Button)findViewById(R.id.mybutton34));
		/**
		 * init button backimg
		 * 
		 */
		button_util.init_button(map, resourse_map, new normal_buttonlistener());
		/**
		 * init button_description
		 */
		button_decription =string_util.init_description_map(res);
				
		bt=(Button)findViewById(R.id.go_button);
		bt.setOnClickListener(new go_buttonlistener());
	}
	class normal_buttonlistener implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	}
	class go_buttonlistener implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			if(!is_started){
//				is_started=true;
//				handler.post(handlerunable);
//			}
//			else{
//				handler.removeCallbacks(handlerunable);
//				is_started=false;
//			}
			Button now_loc_button;
			/**
			 * 先还原上次格子的图片
			 */
			now_loc_button=map.get(now_pos);
			now_loc_button.setBackgroundDrawable(resourse_map.get(now_pos));
			/**
			 * 掷随机数
			 */
			int randint=1+new Random().nextInt(6);

			/**
			 * v1.0  替换当前位置图片 √
			 * v1.1 迭代替换路径图片  
			 * v1.2 判断最终位置行为
			 */
			//移动棋子
			for(int i=randint;i>0;i--){
		//	now_pos=now_pos+randint;
				now_loc_button=map.get(now_pos);
				now_loc_button.setBackgroundDrawable(resourse_map.get(now_pos));
				now_pos++;
				if(now_pos>40){
					now_pos=40;
					break;
				}
				now_loc_button=map.get(now_pos);
				now_loc_button.setBackgroundDrawable(chessman);
				
				//sleep then move again
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//判断行为 并 生成描述
			String description="";
			System.out.println(now_pos);
			description = button_decription.get(now_pos);
//			String description=button_decription.get(now_pos);
			
			System.out.println(description);
			Toast.makeText(MainActivity.this, description,Toast.LENGTH_SHORT).show();
			
//			now_loc.setBackground(background)
			
		}
	}
//	Handler handler=new Handler();
//	Runnable handlerunable=new Runnable() {
//		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			System.out.println("hello world!");
//			handler.postDelayed(handlerunable, 1000);
//		}
//	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv.setText("In my way.");
		bt.setText("hear me?");
		bt.setOnClickListener(new go_buttonlistener());
	}

}
