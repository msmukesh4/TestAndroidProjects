package com.example.encryption_decryption;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

	
	EditText et;
	TextView tv_encrypt,tv_decrypt;
	String text=null,encrypted=null,decrypted=null;
	Button btn_encrypt,btn_decrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et = (EditText) findViewById(R.id.input);
        tv_encrypt = (TextView) findViewById(R.id.encrypt);
        tv_decrypt = (TextView) findViewById(R.id.decrypt);
        btn_encrypt = (Button) findViewById(R.id.button1);
        btn_decrypt = (Button) findViewById(R.id.button2);
        
      
        
        btn_encrypt.setOnClickListener(this);
        btn_decrypt.setOnClickListener(this);
        
    }
	private void decryption(String txt) {
		// TODO Auto-generated method stub
		char[] mesg=txt.toCharArray();

        int ml=mesg.length;
        char[] newmsg=new char[ml];

        for (int i=0; i<ml; i++){
           newmsg[i]=(char)(mesg[i]/5);
        }
        decrypted = new String(newmsg);
        
      
	}
	private void encryption(String txt) {
		// TODO Auto-generated method stub
		char[] mesg=txt.toCharArray();

        int ml=mesg.length;
        char[] newmsg=new char[ml];

        for (int i=0; i<ml; i++){
           newmsg[i]=(char)(mesg[i]*5);
        }
        encrypted = new String(newmsg);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			text = et.getText().toString();
			if(text!=null){
				encryption(text);
				tv_encrypt.setText(encrypted);
			}else{
				Toast.makeText(getApplicationContext(), "Please Enter Some Values", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.button2:
			if (encrypted!=null) {
				decryption(encrypted);	
				tv_decrypt.setText(decrypted);
			}else{
				Toast.makeText(getApplicationContext(), "Encryption not performed", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}
	}
    
}
