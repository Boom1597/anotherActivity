package com.example.thirdactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends Activity{
	TextView lifeView,statusView;
	//ArrayList<String> lifeList=new ArrayList<String>(),statusList=new ArrayList<String>();
	Button start_A,start_C,finish_B,Dialog;
	Data data ;
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
        setContentView(R.layout.activityb);
        lifeView=(TextView)findViewById(R.id.Blife1);
        lifeView.setMovementMethod(ScrollingMovementMethod.getInstance());
        statusView=(TextView)findViewById(R.id.Bstatus1);
        start_A=(Button)findViewById(R.id.Bstart_A);
        start_A.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(BActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
        start_C=(Button)findViewById(R.id.Bstart_C);
        start_C.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(BActivity.this,CActivity.class);
				startActivity(intent);
			}
		});
        finish_B=(Button)findViewById(R.id.Bfinish_B);
        finish_B.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        Dialog=(Button)findViewById(R.id.BDialog);
        Dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(BActivity.this, Dialog.class);
				startActivity(intent);
			}
		});
        data =(Data)getApplication();
        data.additem("B:onCreate\n");
        lifeView.setText(data.getstr());
        handler.postDelayed(runnable, 1000 );
    }

    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	//lifeView.append("B onstart\n");
    	data.additem("B onstart\n");
    	lifeView.setText(data.getstr());
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	//lifeView.append("B onResume\n");
    	data.additem("B onResume\n");
    	lifeView.setText(data.getstr());
    }
    
    @Override
    protected void onStop()
    {
    	super.onStop();
    	//lifeView.append("B onStop\n");
    	data.additem("B onStop\n");
    	lifeView.setText(data.getstr());
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//lifeView.append("B onDestroy\n");
		data.additem("B onDestroy\n");
		lifeView.setText(data.getstr());
		handler.removeCallbacks(runnable); //停止刷新  
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//lifeView.append("B onPause\n");
		data.additem("B onPause\n");
		lifeView.setText(data.getstr());
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu; this adds items to the action bar if it is present.
	    getMenuInflater().inflate(R.menu.bact, menu);
	    return true;
	}

}
