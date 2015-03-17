package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class PhoneDialerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        final EditText editText = (EditText)findViewById(R.id.id_edit_text);
        Button button1 = (Button)findViewById(R.id.id1);
        Button button2 = (Button)findViewById(R.id.id2);
        Button button3 = (Button)findViewById(R.id.id3);
        Button button4 = (Button)findViewById(R.id.id4);
        Button button5 = (Button)findViewById(R.id.id5);
        Button button6 = (Button)findViewById(R.id.id6);
        Button button7 = (Button)findViewById(R.id.id7);
        Button button8 = (Button)findViewById(R.id.id8);
        Button button9 = (Button)findViewById(R.id.id9);
        Button button0 = (Button)findViewById(R.id.id0);
        Button button10 = (Button)findViewById(R.id.id10);
        Button button11 = (Button)findViewById(R.id.id11);
        ImageButton button_back = (ImageButton)findViewById(R.id.id_img_button);
        ImageButton button_on = (ImageButton)findViewById(R.id.img_on);
        ImageButton button_off = (ImageButton)findViewById(R.id.img_off);
        
        class MyLisener implements View.OnClickListener {

        	private char character;
        	public MyLisener(char c) {
        		character = c;
			}
        	
			@Override
			public void onClick(View v) {
				
				if(character == '<') {
					String currentText = editText.getText().toString();
					if(currentText != null) {
						currentText = currentText.substring(0, currentText.length()-1);
						editText.setText(currentText);
					}
					
				} else if(character == 'a') {
					String currentText = editText.getText().toString();
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+ currentText));
					startActivity(intent);
				} else if(character == 'c') {
					finish();
				} else {
					String currentText = editText.getText().toString();
					editText.setText(currentText + character);
				}
				
			}
        }
        
        button1.setOnClickListener(new MyLisener('1'));
        button2.setOnClickListener(new MyLisener('2'));
        button3.setOnClickListener(new MyLisener('3'));
        button4.setOnClickListener(new MyLisener('4'));
        button5.setOnClickListener(new MyLisener('5'));
        button6.setOnClickListener(new MyLisener('6'));
        button7.setOnClickListener(new MyLisener('7'));
        button8.setOnClickListener(new MyLisener('8'));
        button9.setOnClickListener(new MyLisener('9'));
        button0.setOnClickListener(new MyLisener('0'));
        button10.setOnClickListener(new MyLisener('*'));
        button11.setOnClickListener(new MyLisener('#'));
        button_back.setOnClickListener(new MyLisener('<'));
        button_on.setOnClickListener(new MyLisener('a'));
        button_off.setOnClickListener(new MyLisener('c'));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
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
