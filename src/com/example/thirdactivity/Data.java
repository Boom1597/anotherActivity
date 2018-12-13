package com.example.thirdactivity;

import java.util.ArrayList;

import android.app.Application;
import android.os.Message;
import android.util.Log;

public class Data extends Application {
	private ArrayList<String> lifeList=new ArrayList<String>();
	private ArrayList<String> statuslist;
	String lifeString;
	public String getstr()
	{
		Log.i("hehe", ""+lifeList.size());
		lifeString="";
		for(int i=lifeList.size()-1;i>=0;i--)
		{
			
			lifeString=lifeString+lifeList.get(i);
		}
		return this.lifeString;
	}
	public void additem(String s)
	{
		lifeList.add(s);
	}
	public void setStr(String string)
	{
		this.lifeString=string;
	}
	public String Statusstr()
	{
		statuslist=new ArrayList<String>();
		String strstatus="";
		boolean finda=false,findb=false,findc=false;
		for(int i=lifeList.size()-1;i>=0;i--)
		{
			/*if(lifeList.get(i).equals("B onDestroy\n"))
			{
				findb=true;
			}
			if(lifeList.get(i).equals("C onDestroy\n"))
			{
				findc=true;
			}*/
			if(finda!=true&&lifeList.get(i).charAt(0)=='A')
			{
				statuslist.add(lifeList.get(i));
				finda=true;
			}
			if(findb!=true&&lifeList.get(i).charAt(0)=='B')
			{
				statuslist.add(lifeList.get(i));
				findb=true;
			}
			if(findc!=true&&lifeList.get(i).charAt(0)=='C')
			{
				statuslist.add(lifeList.get(i));
				findc=true;
			}
			
		}
		for(String i:statuslist)
		{
			strstatus=strstatus+i;
		}
		return strstatus;
	}
	@Override
	public void onCreate()
	{
		super.onCreate();
		setStr("");
	}
		
		
}
