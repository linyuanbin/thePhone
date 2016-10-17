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
        //Oncreat ����activity ������ ������Դ�ڲ���
        setContentView(R.layout.activity_main);
                      
        //�ҵ���ť
        Button button=(Button) this.findViewById(R.id.button);
        //���õ���¼� 0
        button.setOnClickListener(new ButtoninclickListener());
       
    }
    
    //�ṩ�ڲ���
    private class ButtoninclickListener implements  View.OnClickListener{
    	private EditText mobileText;
		public void onClick(View v){
    		mobileText = (EditText) findViewById(R.id.number2);
    		String number=mobileText.getText().toString();
    		Intent intent =new Intent();//��ͼ
    		intent.setAction("android.intent.action.CALL");
    		intent.setData(Uri.parse("tel:"+number));//��Ҫ���ĺ���
    		startActivity(intent);
    	}
    }
    //�ڲ������
   
    //�����ֵ���¼�
    public void click(View v){
      callphone();
   }
    
	private void callphone() {
		mobileText2 = (EditText) findViewById(R.id.number2);
   String number=mobileText2.getText().toString().trim();
		if("".equals(number)){
		Toast.makeText(MainActivity.this, "number����Ϊ��",1).show();
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
