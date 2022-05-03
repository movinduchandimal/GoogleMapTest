package com.example.mygooglemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mygooglemap.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    // Add a marker in Sydney and move the camera
    val uoc = LatLng(6.927079, 79.861244)
    val uok = LatLng(6.9553, 79.922)
    val uspj = LatLng(6.8528,79.9036)
    val uom = LatLng(6.7951,79.9009)
    val uor = LatLng(5.9381, 80.5761)
    val usab = LatLng(6.7146, 80.7872)
    val uop = LatLng(7.2549, 80.5974)
    val uraj = LatLng(8.3608, 80.5033)
    val uway = LatLng(7.3226, 79.9882)



    private var locationArrayList: ArrayList<LatLng>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(uoc)
        locationArrayList!!.add(uok)
        locationArrayList!!.add(uspj)
        locationArrayList!!.add(uom)
        locationArrayList!!.add(uor)
        locationArrayList!!.add(usab)
        locationArrayList!!.add(uop)
        locationArrayList!!.add(uraj)
        locationArrayList!!.add(uway)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        for (i in locationArrayList!!.indices){

            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("University"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))
            mMap.setMinZoomPreference(10f)
        }
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


    }
}