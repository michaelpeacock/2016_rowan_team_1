package team2.lostatsea;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import static team2.lostatsea.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Vessel[] myList = new Vessel[1047];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss SS");
        Scanner scanner = null;
        File f= new File("ais.csv");
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count =0;
        scanner.useDelimiter(",");
        while(scanner.hasNext()){

            String t =  scanner.next();
            Date d = null;
            try {
                d = inputFormat.parse(t);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String whatever= scanner.next();
            String latitude= scanner.next();
            String longitude = scanner.next();
            double x =  Double.parseDouble(latitude);
            double y = Double.parseDouble(longitude);
            Point p = new Point(x, y);
            String head = scanner.next();
            double heading =Double.parseDouble(head);
            String speedo = scanner.next();
            double speed =Double.parseDouble(speedo);
            whatever= scanner.next();
            whatever= scanner.next();
            String Name= scanner.next();
            for (int i=0; i<8; i++)
            {
                whatever= scanner.next();
            }
            String E= scanner.next();

            Date ETA= null;
            try {
                ETA = inputFormat.parse(E);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Vessel v= new Vessel(d ,p, speed, heading, ETA, Name );
            myList[count]= v;
            count++;
        }
        scanner.close(); */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be use


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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//Vessel i= myList[1];

        // Add a marker in Sydney and move the camera
        LatLng lal  = new LatLng(36.4746, 16.57737);
        mMap.addMarker(new MarkerOptions().position(lal).title("BALTICDIEP")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.harbor)));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(lal));
        Polygon c = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(37.8, 16.5), new LatLng(37.8, 16.5), new LatLng(34.3, 15.3), new LatLng(36.3, 18.4))
                .strokeColor(Color.RED)
                .strokeWidth(1)
                .fillColor(Color.GRAY));
        LatLng go  = new LatLng(36.9746, 15.9);
        mMap.addMarker(new MarkerOptions().position(go).title("Probablity: 0.33")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        Polygon p = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(37.7, 16.2), new LatLng(37.7, 16.2), new LatLng(34.2, 15.1), new LatLng(36.2, 18.1))
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.CYAN));
        Polygon polygon = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(37.5, 16), new LatLng(37.5, 16), new LatLng(34, 15), new LatLng(36.5, 17))
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.BLUE));
        LatLng t= new LatLng(38.4237, 27.1428);

        mMap.addMarker(new MarkerOptions().position(t).title("Destination: IZMIR "));



    }
}
