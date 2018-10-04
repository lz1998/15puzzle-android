package xin.lz1998.a15puzzle;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TimeView extends TextView {
    public TimeView(Context context,AttributeSet attrs) {
        super(context, attrs);
    }
    public void refresh(){
        long time=System.currentTimeMillis()-Config.startTime;
        int ms=(int)(time%1000);
        int sec=(int)(time/1000);
        int min=sec/60;
        sec%=60;
        setText(String.format("%1$02d:%2$02d.%3$03d",min,sec,ms));
    }

}
