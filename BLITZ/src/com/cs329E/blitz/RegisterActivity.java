package com.cs329E.blitz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private static final String TAG = "registeractivity";
	private EditText usernameEdit;
	private EditText passwordEdit;
	private EditText confirmPasswordEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_register);
		usernameEdit = (EditText) findViewById(R.id.usernameText);
		passwordEdit = (EditText) findViewById(R.id.passwordText);
		confirmPasswordEdit = (EditText) findViewById(R.id.passwordConfirmText);
		
		Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
		usernameEdit.setTypeface(GillSansLight);
		passwordEdit.setTypeface(GillSansLight);
		confirmPasswordEdit.setTypeface(GillSansLight);
		
		
		final Button registrationButton = (Button) findViewById(R.id.register_user_button);
		registrationButton.setTypeface(GillSansLight);
		
		registrationButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {			
				Log.v(TAG, "closing the register screen");
				signupClicked();
			}
		});	
	}
	
	private void signupClicked() {

		Log.i(TAG,"Entered signupClicked()");		
		String username = usernameEdit.getText().toString();
		String password = passwordEdit.getText().toString();
		String confirmPassword = confirmPasswordEdit.getText().toString();
		
		if (password.equals(confirmPassword) && password.length() != 0 && username.length() != 0){
			Log.i(TAG,"Entered Registration Succeeded");
			
			Intent explicitCallbackIntent = new Intent(this, LoginActivity.class);
			explicitCallbackIntent.putExtra("Explicit_Activity", username);// (String name, String value)
			setResult(RESULT_OK, explicitCallbackIntent);
			this.finish();
		}
		else{
			Toast toast = new Toast(getApplicationContext());

	        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	        toast.setDuration(Toast.LENGTH_LONG);
	        
	        toast.setView(getLayoutInflater().inflate(R.layout.custom_toast,null));

	        toast.show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
