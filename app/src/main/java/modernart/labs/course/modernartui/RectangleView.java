package modernart.labs.course.modernartui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by olive_000 on 28/02/2017.
 */
public class RectangleView extends View {

    public Paint paint1,paint2,paint3,paint4,paint5;

    public RectangleView(Context context)
    {
        super(context);

    }

    public RectangleView(Context context, AttributeSet attrs){
        super(context,attrs);

        paint1 = new Paint();
        paint1.setColor(Color.rgb(255,51,0));  //Orange

        paint2 = new Paint();
        paint2.setColor(Color.rgb(0,153,0));  //Green

        paint3 = new Paint();
        paint3.setColor(Color.WHITE);
        paint4 = new Paint();
        paint4.setColor(Color.rgb(255,255,26));  //Blue
        paint5 = new Paint();
        paint5.setColor(Color.rgb(255,102,204));  //Pink
    }

    @Override
    protected void onDraw(Canvas canvas){
        float x = getWidth();
        float y = getHeight();

        canvas.drawRect(0,0,x/3,2*(y/3),paint1);
        canvas.drawRect(x/3,0,2*(x/3),y/2,paint2);
        canvas.drawRect(2*(x/3),0,x,y/2,paint3);
        canvas.drawRect(0,2*(y/3),x,y,paint4);
        canvas.drawRect(x/3,y/2,x,2*(y/3),paint5);

    }
}
