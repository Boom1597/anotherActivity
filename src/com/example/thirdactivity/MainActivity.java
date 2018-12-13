package com.example.thirdactivity;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView lifeView,statusView;
	//ArrayList<String> lifeList=new ArrayList<String>(),statusList=new ArrayList<String>();
	Button start_B,start_C,finish_A,Dialog;
	Data data;
	Handler handler=new Handler();
	private Runnable runnable = new Runnable() {  
        public void run() {  
            this.update();  
            handler.postDelayed(this, 1000);// 间隔1秒  
        }  
        void update() {  
            //刷新msg的内容  
        	lifeView.setText(data.getstr());
        	statusView.setText(data.Statusstr());
        }  
    };   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("hehe", "create");
        data=(Data)getApplication();
        lifeView=(TextView)findViewById(R.id.life1);
        lifeView.setMovementMethod(ScrollingMovementMethod.getInstance());
        statusView=(TextView)findViewById(R.id.status1);
        start_B=(Button)findViewById(R.id.start_B);
        start_B.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,BActivity.class);
				startActivity(intent);
			}
		});
        start_C=(Button)findViewById(R.id.start_C);
        start_C.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,CActivity.class);
				startActivity(intent);
			}
		});
        finish_A=(Button)findViewById(R.id.finish_A);
        finish_A.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        Dialog=(Button)findViewById(R.id.Dialog);
        Dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, Dialog.class);
				startActivity(intent);
			}
		});
        data.additem("A:onCreate\n");
        Log.i("hehe", ""+data.getstr());
        lifeView.setText(data.getstr());
        handler.postDelayed(runnable, 1000 );
    }

    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	//Log.i("hehe", "start");
    	//lifeView.append("A onstart\n");
    	data.additem("A onstart\n");
    	lifeView.setText(data.getstr());
  
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	//lifeView.append("A onResume\n");
    	data.additem("A onResume\n");
    	lifeView.setText(data.getstr());
    	//Log.i("hehe", "resume");
    }
    
    @Override
    protected void onStop()
    {
    	super.onStop();
    	//lifeView.append("A onStop\n");
    	data.additem("A onStop\n");
    	lifeView.setText(data.getstr());
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//lifeView.append("A onDestroy\n");
		data.additem("A onDestroy\n");
		lifeView.setText(data.getstr());
		handler.removeCallbacks(runnable); //停止刷新  
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//lifeView.append("A onPause\n");
		data.additem("A onPause\n");
		lifeView.setText(data.getstr());
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
