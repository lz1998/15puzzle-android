package xin.lz1998.a15puzzle;


import java.util.Random;

public class Game {
    static SquareView[][] sv=new SquareView[4][4];


    public static void setGame(SquareView[][] sv1)
    { sv=sv1; }
    public static void show()
    {
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
            {
                sv[i][j].setNum(Config.map[i][j]);
            }
    }
    public static void play(int num)
    {
        if(Config.scramble){
            Config.scramble=false;
            Config.start=true;
            Config.startTime=System.currentTimeMillis();
        }
        int row=0,col=0,t;
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                if(Config.map[i][j]==num)
                {
                    row=i;
                    col=j;
                }

        //Toast.makeText(MainActivity.this.getContext(),num+","+row+","+col,Toast.LENGTH_SHORT).show();
        if(row-1>=0 && Config.map[row-1][col]==0)
        {
            Config.map[row-1][col]=Config.map[row][col];
            Config.map[row][col]=0;
            Config.count++;
        }
        else if(row+1<4 && Config.map[row+1][col]==0)
        {
            Config.map[row+1][col]=Config.map[row][col];
            Config.map[row][col]=0;
            Config.count++;
        }
        else if(col-1>=0 && Config.map[row][col-1]==0)
        {
            Config.map[row][col-1]=Config.map[row][col];
            Config.map[row][col]=0;
            Config.count++;
        }
        else if(col+1<4 && Config.map[row][col+1]==0)
        {
            Config.map[row][col+1]=Config.map[row][col];
            Config.map[row][col]=0;
            Config.count++;
        }
        else
            return;
        show();
        if(Game.isWin())
            Config.start=false;
    }
    public static boolean isWin()
    {
        if(Config.map[0][0]!=1)return false;
        if(Config.map[0][1]!=2)return false;
        if(Config.map[0][2]!=3)return false;
        if(Config.map[0][3]!=4)return false;
        if(Config.map[1][0]!=5)return false;
        if(Config.map[1][1]!=6)return false;
        if(Config.map[1][2]!=7)return false;
        if(Config.map[1][3]!=8)return false;
        if(Config.map[2][0]!=9)return false;
        if(Config.map[2][1]!=10)return false;
        if(Config.map[2][2]!=11)return false;
        if(Config.map[2][3]!=12)return false;
        if(Config.map[3][0]!=13)return false;
        if(Config.map[3][1]!=14)return false;
        if(Config.map[3][2]!=15)return false;
        if(Config.map[3][3]!=0)return false;
        return true;
    }
    public static void scramble(){

        int[] num=new int[16];
        Random random=new Random();

        for(int i=0;i<16;i++)
            num[i]=i;
        for(int i=15;i>0;i--){
            int rnd=random.nextInt(i);
            int t=num[rnd];
            num[rnd]=num[i];
            num[i]=t;
        }//洗牌算法，随机打乱

        int sum=0;
        for(int i=0;i<16;i++){
            if(num[i]==0){
                sum+=i/4+(i+1)%4;
                continue;
            }
            for(int j=0;j<16-i;j++)
                if(num[j+i]<num[i])
                    sum++;

        }//计算逆序数

        if(sum%2==1){
            int r1=random.nextInt(16);
            if(num[r1]==0)
                if(++r1>15)
                    r1=0;
            int r2=random.nextInt(16);
            while(r1==r2 || num[r2]==0)
                if(++r1>15)
                    r2=0;
            int t;
            t=num[r1];
            num[r1]=num[r2];
            num[r2]=t;
        }//逆序数是奇数，交换任意2个不为0的

        for(int i=0;i<16;i++)
            Config.map[i/4][i%4]=num[i];
        show();
        Config.start=false;
        Config.count=0;
        Config.scramble=true;
    }
}
