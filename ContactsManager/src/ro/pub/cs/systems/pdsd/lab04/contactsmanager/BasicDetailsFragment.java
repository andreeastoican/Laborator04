package ro.pub.cs.systems.pdsd.lab04.contactsmanager;


import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class BasicDetailsFragment extends Fragment {
 
	final private static int CONTACTS_MANAGER_REQUEST_CODE = 2015;
	
  @Override
  public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle state) {
    return layoutInflater.inflate(R.layout.fragment_basic_details, container, false);
  }
  
  private AdditionalDetailsFragment additionalDetailsFragment = null;
  
  @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		Button showHideDetails = (Button)getActivity().findViewById(R.id.id_additional_filed);
		Button saveButton = (Button)getActivity().findViewById(R.id.id_save);
		Button cancelButton = (Button)getActivity().findViewById(R.id.id_cancel);
		
		showHideDetails.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

				if (additionalDetailsFragment == null) {
				  additionalDetailsFragment = new AdditionalDetailsFragment();
				  fragmentTransaction.add(R.id.id_frame2, additionalDetailsFragment);
				  ((Button)v).setText(getActivity().getResources().getString(R.string.hide_additional_fields));
				  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
				} else {
				  fragmentTransaction.remove(additionalDetailsFragment);
				  ((Button)v).setText(getActivity().getResources().getString(R.string.show_additional_fields));
				  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK);
				  additionalDetailsFragment = null;
				}
				fragmentTransaction.commit();
			}
		});
		
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText editTextName = (EditText) getActivity().findViewById(R.id.id_name);
				String name = editTextName.getText().toString();
				
				EditText editTextPhone = (EditText)getActivity().findViewById(R.id.id_phone);
				String phone = editTextPhone.getText().toString();
				
				EditText editTextEmail = (EditText)getActivity().findViewById(R.id.id_email);
				String email = editTextEmail.getText().toString();
				
				EditText editTextAdd = (EditText)getActivity().findViewById(R.id.id_address);
				String address = editTextAdd.getText().toString();
				
				EditText editTextJobTitle = (EditText)getActivity().findViewById(R.id.id_job);
				String jobTitle = editTextJobTitle.getText().toString();
				
				EditText editTextCompany = (EditText)getActivity().findViewById(R.id.id_company);
				String company = editTextCompany.getText().toString();
				
				EditText editTextWebSite = (EditText)getActivity().findViewById(R.id.id_website);
				String website = editTextWebSite.getText().toString();
				
				EditText editTextIM = (EditText)getActivity().findViewById(R.id.id_im);
				String im = editTextIM.getText().toString();
				
				Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
				intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
				if (name != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
				}
				if (phone != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
				}
				if (email != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
				}
				if (address != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address);
				}
				if (jobTitle != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
				}
				if (company != null) {
				  intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
				}
				ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
				if (website != null) {
				  ContentValues websiteRow = new ContentValues();
				  websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
				  websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
				  contactData.add(websiteRow);
				}
				if (im != null) {
				  ContentValues imRow = new ContentValues();
				  imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
				  imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
				  contactData.add(imRow);
				}
				intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
				getActivity().startActivity(intent);
				
				getActivity().startActivityForResult(intent, CONTACTS_MANAGER_REQUEST_CODE);
			}
		});
		
		cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().finish();
				
				getActivity().setResult(Activity.RESULT_CANCELED, new Intent());
			}
		});
		
		Intent intent = getActivity().getIntent();
		if (intent != null) {
		  EditText editTextPhone = (EditText)getActivity().findViewById(R.id.id_phone);
		  String phone = intent.getStringExtra("ro.pub.cs.systems.pdsd.lab04.contactsmanager.PHONE_NUMBER_KEY");
		  if (phone != null) {
			  editTextPhone.setText(phone);
		  } else {
		    Activity activity = getActivity();
		    Toast.makeText(activity, activity.getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
		  }
		} 
	}
 
}