package com.mad.googlemap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity
{

	private GoogleMap mMap;
	public static LatLng INDIA = new LatLng(21.00, 78.00);
	public static LatLng AHMEDABAD = new LatLng(23.0300, 72.5800);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		MarkerOptions markerIndia = new MarkerOptions().position(INDIA).title("India");
		// ROSE color icon
		markerIndia.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
		mMap.addMarker(markerIndia);

		MarkerOptions markerAhmedabad = new MarkerOptions().position(AHMEDABAD).title("Ahmedabad");
		markerAhmedabad.snippet("Gujarat");
		// from Resource
		markerAhmedabad.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

		mMap.addMarker(markerAhmedabad);

		CameraPosition cameraPosition = new CameraPosition.Builder().target(AHMEDABAD).zoom(5).build();

		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
