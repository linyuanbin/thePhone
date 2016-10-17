package com.lin.thePhone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    
@SuppressLint("NewApi") public class MainActivity extends ActionBarActivity {
	private EditText mobileText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Oncreat 设置activity 的内容 内容来源于布局
        setContentView(R.layout.activity_main);
                      
        //找到按钮
        Button button=(Button) this.findViewById(R.id.button);
        //设置点击事件 0
        button.setOnClickListener(new ButtoninclickListener());
       
    }
    
    //提供内部类
    private class ButtoninclickListener implements  View.OnClickListener{
    	private EditText mobileText;
		public void onClick(View v){
    		mobileText = (EditText) findViewById(R.id.number2);
    		String number=mobileText.getText().toString();
    		Intent intent =new Intent();//意图
    		intent.setAction("android.intent.action.CALL");
    		intent.setData(Uri.parse("tel:"+number));//需要传的号码
    		startActivity(intent);
    	}
    }
    //内部类结束
   
    //第四种点击事件
    public void click(View v){
      callphone();
   }
    
	private void callphone() {
		mobileText2 = (EditText) findViewById(R.id.number2);
   String number=mobileText2.getText().toString().trim();
		if("".equals(number)){
		Toast.makeText(MainActivity.this, "number不能为空",1).show();
		return ;
		}
		
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
