package xin.lz1998.a15puzzle;

public class Config {
    public static int LEFT=1;
    public static int RIGHT=2;
    public static int UP=3;
    public static int DOWN=4;
    public static long startTime=0;
    public static boolean start=false;
    public static int count=0;
    public static int[] color_red={1,2,3,4,5,9,13};
    public static int[] color_blue={6,7,8,10,14};
    public static int[] color_green={11,12,15};
    public static int[][] map=new int[][]
            {
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
}
