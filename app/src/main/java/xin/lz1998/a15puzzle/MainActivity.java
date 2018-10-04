package xin.lz1998.a15puzzle;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import static xin.lz1998.a15puzzle.Game.show;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainMenuAbout:
                Toast.makeText(this,"AUTHOR QQ:875543533",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mainMenuExit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimeView tv=findViewById(R.id.timeView1);
        final TextView tv2=findViewById(R.id.textView1);
        SquareView[][] sv=new SquareView[4][4];

        sv[0][0]=findViewById(R.id.square0);
        sv[0][1]=findViewById(R.id.square1);
        sv[0][2]=findViewById(R.id.square2);
        sv[0][3]=findViewById(R.id.square3);

        sv[1][0]=findViewById(R.id.square4);
        sv[1][1]=findViewById(R.id.square5);
        sv[1][2]=findViewById(R.id.square6);
        sv[1][3]=findViewById(R.id.square7);

        sv[2][0]=findViewById(R.id.square8);
        sv[2][1]=findViewById(R.id.square9);
        sv[2][2]=findViewById(R.id.square10);
        sv[2][3]=findViewById(R.id.square11);

        sv[3][0]=findViewById(R.id.square12);
        sv[3][1]=findViewById(R.id.square13);
        sv[3][2]=findViewById(R.id.square14);
        sv[3][3]=findViewById(R.id.square15);

        Game.setGame(sv);
        show();
        final Handler myHandler = new Handler() {
            public void handleMessage(Message msg) {
                if(msg.what==1998){
                    tv.refresh();
                    tv2.setText("Moves:"+Config.count);
                }

                super.handleMessage(msg);
            }
        };
        Thread t=new Thread(){
            public void run(){
                while(true){
                    if(Config.start){
                        Message msg=new Message();
                        msg.what=1998;
                        myHandler.sendMessage(msg);
                    }

                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();


    }

    public void scrambleOnClick(View view) {
        Game.scramble();
    }
}
