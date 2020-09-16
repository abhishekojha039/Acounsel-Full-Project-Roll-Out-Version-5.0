package com.edge.examfinder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,examAdapter.OnIteam1ClickListner,compAdapter.OnIteamClickListner {
    TextView txt1;
    TextView txt3, txt2, txxt1,txt4;
    CardView card1,card2,card3,card4;
    LinearLayout ww;
    TextView fabin,gmail;
    ImageView imgIcon;
    Uri userImage;
    String email,Gmail;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private RecyclerView mRecycler,nRecycler;
    private examAdapter examAdapters;
    private  compAdapter compAdapters;
    private ArrayList<examRecycler> examRecyclers;
    private ArrayList<compRecycler> compRecyclers;
    private RequestQueue mRequestQueue,nRequestQueue;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt3 = findViewById(R.id.txt33);
      //  fabin=findViewById(R.id.fabini);
        txt4=findViewById(R.id.txt44);
      // imgIcon=findViewById(R.id.imageIcon);
        mRecycler = findViewById(R.id.examRecycler);
        nRecycler=findViewById(R.id.examComp);
        nRecycler.setHasFixedSize(true);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        nRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        examRecyclers = new ArrayList<>();
        compRecyclers= new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        nRequestQueue = Volley.newRequestQueue(this);
        parseJson();
        parseJson1();
        ww = findViewById(R.id.ww);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        txt2 = findViewById(R.id.txt2);
        txxt1 = findViewById(R.id.txxt1);
        mAuth = FirebaseAuth.getInstance();



        FirebaseUser mUser = mAuth.getCurrentUser();
        txt1 = findViewById(R.id.txt1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myNotifications", "myNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        FirebaseMessaging.getInstance().subscribeToTopic("abhi")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "successful";
                        if (!task.isSuccessful()) {
                            msg = "failed...";
                        }

                        //  Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();
                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
               // Toast.makeText(this, ""+profile.getPhoneNumber(), Toast.LENGTH_SHORT).show();
                userImage = profile.getPhotoUrl();



                // Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            }
        }


        //  GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        // Uri photoUrl = acct.getPhotoUrl();
        // Toast.makeText(this, ""+photoUrl, Toast.LENGTH_SHORT).show();
      /*  GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {

            String url = acct.getPhotoUrl().toString();
            Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        }
*/
      /*  GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Toast.makeText(this, "--"+personName, Toast.LENGTH_SHORT).show();
          //  Uri personPhoto = acct.getPhotoUrl();
        }

*/

        if (mUser != null) {

            email = mUser.getDisplayName();
            Gmail=mUser.getEmail();


        }
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bio1.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, arts1.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, commerce1.class);
                startActivity(intent);
            }
        });
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, math1.class);
                startActivity(intent);

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "No notifications", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
        txxt1.setText(null);
                startActivity(new Intent(MainActivity.this, myNotification.class));
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        /*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        fabin = (TextView) header.findViewById(R.id.fabini);
        gmail=(TextView) header.findViewById(R.id.gmail);
        imgIcon=(ImageView) header.findViewById(R.id.imageIcon);
      //  Picasso.get().load(userImage).centerInside().resize(50,50).placeholder(R.drawable.logo_image).into(imgIcon);
        Picasso.get().load(userImage).fit().placeholder(R.drawable.logo_image).centerInside().into(imgIcon);
         gmail.setText(Gmail);
        fabin.setText(email);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!drawer.isDrawerOpen(GravityCompat.START)) {
            // super.onBackPressed();
            //Toast.makeText(this, "khatam", Toast.LENGTH_SHORT).show();
            finishAffinity();
        }
    }
    private MenuItem mProfileMenuItem,check;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        mProfileMenuItem = menu.findItem(R.id.action_settings);
        check=menu.findItem(R.id.eligibility);

       /* Glide.with(this)
                .asBitmap()
                .load(userImage)
                .placeholder(R.drawable.logo_image)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        mProfileMenuItem.setIcon(new BitmapDrawable(getResources(), resource));
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });*/

        Glide
                .with(this)
                .load(userImage).placeholder(R.drawable.logo_image)
                .circleCrop()
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        mProfileMenuItem.setIcon(resource);
                    }
                });
       // Picasso.get().load(userImage).fit().placeholder(R.drawable.logo_image).centerInside().into(new Bitmap(mProfileMenuItem));
              //  mProfileMenuItem.setIcon(new BitmapDrawable(getResources(), myBitmap));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(item.getTitle().equals("check"))
        {
            startActivity(new Intent(MainActivity.this,profile.class));

        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, lets.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MainActivity.this, Feedback.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), googleLogin.class));
        } else if (id == R.id.aboutus) {
            startActivity(new Intent(getApplicationContext(), about_us.class));
        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.edge.examfinder";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        } else if (id == R.id.nav_noti) {
            txxt1.setText(null);
            startActivity(new Intent(MainActivity.this, myNotification.class));
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void parseJson() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String url = "https://next.json-generator.com/api/json/get/4JgqRpSZY";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("exams");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String title = hit.getString("title");
                                String imageURL = hit.getString("image");

                                examRecyclers.add(new examRecycler(imageURL, title));


                            }
                            examAdapters = new examAdapter(MainActivity.this, examRecyclers);
                            mRecycler.setAdapter(examAdapters);
                            examAdapters.setOnIteam1ClickListner(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
    private void parseJson1() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String url = "https://next.json-generator.com/api/json/get/418boNIWF";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("comp");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String title = hit.getString("title");
                                String imageURL = hit.getString("image");

                                compRecyclers.add(new compRecycler(imageURL, title));


                            }
                            compAdapters = new compAdapter(MainActivity.this, compRecyclers);
                            nRecycler.setAdapter(compAdapters);
                            compAdapters.setOnIteamClickListner(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        count = pref.getInt("count", -1);
        if (count > 0) {
            txxt1.setText("!!" );
        } else {
            txxt1.setText(null);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, finalActivity.class);
        intent.putExtra("count","exams");
        intent.putExtra("mount",position);
        startActivity(intent);
    }

    @Override
    public void onIteamClick(int position) {
        Intent intent = new Intent(this, finalActivity.class);
        intent.putExtra("count","comp");
        intent.putExtra("mount",position);
        startActivity(intent);
    }
}