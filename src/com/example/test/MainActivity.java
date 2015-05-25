package com.example.test;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText mcardid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bmob.initialize(this, "23f9dd93358e5bbe06c451007f701423");
		mcardid=(EditText)findViewById(R.id.cardid);
	}
	public void submit(View view){
		String cardid=mcardid.getText().toString();
		if (cardid.equals("")) {
			return;
		}
		cardid cardidobj=new cardid();
		cardidobj.setCardid(cardid);
		cardidobj.save(this,new SaveListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"提交成功", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"提交失败，该卡数据已存在", Toast.LENGTH_SHORT).show();

			}
		});
		
		
	}

	
}
