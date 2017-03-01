package modernart.labs.course.modernartui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.widget.SeekBar;

/**
 * Created by olive_000 on 1/03/2017.
 */


public class MySeekBar implements SeekBar.OnSeekBarChangeListener {

    private final String TAG = "MySeekBar";
    private Context mycontext;
    RectangleView v;

    public MySeekBar(Context context)
    {
        Log.i(TAG, "new MySeekBar");
        v = ((MainActivity)context).v;
    }

    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser)
    {
        v.paint1.setColor(Color.rgb(255 - (progressValue * 2), 51 + progressValue, 0 + (progressValue * 2)));
        v.paint2.setColor(Color.rgb(0 + progressValue*2,153-progressValue,0+progressValue));
        v.paint4.setColor(Color.rgb(255 - progressValue, 255 - (progressValue * 2), 26+progressValue));
        v.paint5.setColor(Color.rgb(255 - (progressValue*2),102 - progressValue,204 - progressValue));
        v.invalidate();
    }

    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }
}
