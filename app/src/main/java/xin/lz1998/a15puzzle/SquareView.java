package xin.lz1998.a15puzzle;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SquareView extends TextView implements View.OnClickListener{
    public int num=10;
    public void setNum(int n)
    {
        num=n;
        this.setText(String.valueOf(num));
        if(num==0){
            //this.setBackgroundColor(0xffffbb33);
            //this.setTextColor(0xffffbb33);
            this.setBackgroundColor(0x00000000);
            this.setTextColor(0x00000000);
        }
        else{
            this.setTextColor(Color.BLACK);
            for(int i=0;i<Config.color_red.length;i++)
                if(num==Config.color_red[i])
                    this.setBackgroundResource(R.drawable.square_view_background_red);
                    //this.setBackgroundColor(Color.rgb(0xea,0x4b,0x35));
            for(int i=0;i<Config.color_blue.length;i++)
                if(num==Config.color_blue[i])
                    this.setBackgroundResource(R.drawable.square_view_background_blue);
                    //this.setBackgroundColor(Color.rgb(0x21,0x7f,0xbc));
            for(int i=0;i<Config.color_green.length;i++)
                if(num==Config.color_green[i])
                    this.setBackgroundResource(R.drawable.square_view_background_green);
                    //this.setBackgroundColor(Color.rgb(0x1b,0xae,0x5d));
            //this.setBackgroundColor(Color.BLACK);
        }


    }
    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setText(String.valueOf(num));
        this.setTextColor(Color.WHITE);
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        this.setGravity(Gravity.CENTER);
        setOnClickListener(this);
        if(num==0)
            this.setBackgroundColor(Color.WHITE);
    }


    @Override
    public void onClick(View v) {

        long time=Game.play(num);
        if(time!=0){
            Toast.makeText(this.getContext(),"YOU WIN!",Toast.LENGTH_SHORT).show();

        }

        //this.setText(String.valueOf(0));
    }
}
