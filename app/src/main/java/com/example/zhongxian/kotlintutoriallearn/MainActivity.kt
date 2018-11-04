package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.zhongxian.kotlintutoriallearn.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.R.attr.scaleHeight
import android.R.attr.scaleWidth
import android.graphics.drawable.ScaleDrawable
import android.support.v4.content.ContextCompat
import android.graphics.drawable.Drawable
import android.widget.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MyBroadcastReceiver.receiverListener {
    lateinit var sharedPreferences : SharedPreferences
    lateinit var receiver: MyBroadcastReceiver
    lateinit var context : Context
    private var myPrefences = "myPrefs"
    private var currentLevel = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val homeFragment = HomeFragment()
        transaction.replace(R.id.main,homeFragment).commit()
        //Toast.makeText(this,"this is home fragment", Toast.LENGTH_LONG).show()

        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE);

        setTitle("Home");
        var userLevel = sharedPreferences.getInt("currentLevel",1)
        val hView = nav_view.getHeaderView(0)
        val androidIcon = hView.findViewById<ImageView>(R.id.ivAndroidIcon)
        val textViewCurrentLevel = hView.findViewById<TextView>(R.id.tvCurrentLevel)
        var text11 = hView.findViewById<TextView>(R.id.textView12)
        var userName = sharedPreferences.getString("userName","");
        //Toast.makeText(this, userName,Toast.LENGTH_SHORT).show()
        showAlertForUsername(userName,text11);
        if (userLevel == 2) {
            androidIcon.setImageResource(R.drawable.level2icon)
            textViewCurrentLevel.setText("Level 2")
        } else if (userLevel == 3) {
            androidIcon.setImageResource(R.drawable.level3icon)
//                    imageView.setImageResource(R.drawable.level3icon)
            textViewCurrentLevel.setText("Level 3")
        } else if (userLevel == 4) {
            androidIcon.setImageResource(R.drawable.level4icon)
            textViewCurrentLevel.setText("Level 4")
        } else if (userLevel == 5) {
            androidIcon.setImageResource(R.drawable.level5icon)
            textViewCurrentLevel.setText("Level 5")
        }



    }

    fun showAlertForUsername(userName:String,text11:TextView){

        if(userName.equals("")){
            val alert = AlertDialog.Builder(this)
            val edittext = EditText(this)
            alert.setMessage("Please enter your name")
            alert.setTitle("Alert")

            alert.setView(edittext)

            alert.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, whichButton ->

                //OR
                val yourEditTextValue = edittext.text.toString()

                if(yourEditTextValue.equals("")){
                    Toast.makeText(this,"Please enter name before continuing", Toast.LENGTH_LONG).show();
                    showAlertForUsername(userName,text11);
                }else{
                    val editor = sharedPreferences.edit()
                    editor.putString("userName", yourEditTextValue)
                    editor.apply()
                    Toast.makeText(this, "UserName set :"+yourEditTextValue,Toast.LENGTH_SHORT).show()
                    text11.text  = yourEditTextValue;
                }

            })


            alert.show()
        }else{
            text11.text  = userName;
        }
    }
    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        receiver = MyBroadcastReceiver()
        registerReceiver(receiver, filter)
        MyBroadcastReceiver.receiverListener = this
    }

    override fun onPause() {
        unregisterReceiver(receiver)
        super.onPause()
    }

    override fun onNetworkConnectionStatusChanged(isConnected: Boolean) {
        if (isConnected == false) {
            Toast.makeText(this, "Hey there! Connect to the internet to access more documents on Kotlin!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Great you are connected to the Internet! Let's start learning Kotlin now!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
//            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.Home -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val homeFragment = HomeFragment()
                transaction.replace(R.id.main,homeFragment).commit()
                setTitle("Home");
                //Toast.makeText(this,"this is home fragment", Toast.LENGTH_LONG).show()
            }
            R.id.helloWorld -> {
                // Handle the camera action
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val fragHellowWorldFragment = HelloWorldFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,fragHellowWorldFragment).commit()
                setTitle("Introduction Hello World");
            }
            R.id.variable_Types -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val variablesTypesFragment = VariablesTypesFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,variablesTypesFragment).commit()
                setTitle("Introduction Variable Types");
            }
            R.id.Operators -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val operatorsFragment = OperatorsFragment()
                transaction.replace(R.id.main,operatorsFragment).commit()
                setTitle("Introduction Operators");
            }
            R.id.Conversion -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val conversionFragment = ConversionFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,conversionFragment).commit()
                setTitle("Introduction Conversion");
            }
            R.id.Quiz -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val quizNavigationFragment = QuizNavigationFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,quizNavigationFragment).commit()
                setTitle("Quiz");
                //Toast.makeText(this,"this is Conversion fragment", Toast.LENGTH_LONG).show()
            }

            R.id.Loop -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val loopFragment = LoopFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,loopFragment).commit()
                setTitle("Intermedeate Loop");
                //Toast.makeText(this,"this is Conversion fragment", Toast.LENGTH_LONG).show()
            }

            R.id.Function -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val functionsFragment = FunctionsFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,functionsFragment).commit()
                setTitle("Intermedeate Function");
            }

            R.id.Object -> {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()
                val objectFragment = ObjectFragment()
                transaction.addToBackStack(null)
                transaction.replace(R.id.main,objectFragment).commit()
                setTitle("Intermedeate Object");
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
