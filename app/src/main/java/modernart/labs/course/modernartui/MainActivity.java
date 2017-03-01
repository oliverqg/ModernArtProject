package modernart.labs.course.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private DialogFragment mDialog;
    public RectangleView v;
    private Canvas canvas;
    SeekBar sbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (RectangleView)findViewById(R.id.vMain);

        canvas = new Canvas();
        v.draw(canvas);
        //setContentView(new RectangleView(this.getBaseContext(), 0, 0, 20, 10));
        sbar = (SeekBar)findViewById(R.id.seekBar1);
        sbar.setOnSeekBarChangeListener(new MySeekBar(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mDialog = AlertDialogFragment.newInstance();
            mDialog.show(getFragmentManager(), "Alert");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMoma() {
        Log.i(TAG, "show Moma");
        Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));

        Intent chooserIntent = Intent.createChooser(baseIntent,null);
        if(baseIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(chooserIntent);
        }
    }

    public static class AlertDialogFragment extends DialogFragment{
        public static AlertDialogFragment newInstance(){
            return new AlertDialogFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Inspired by the work of Guatemalan Modern Artists").setCancelable(false)
                    .setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ((MainActivity) getActivity()).showMoma();
                        }
                    }).create();


        }
    }

}


