public class SetColor
{
    SetColor(int x, int y, int rgb)
    {
        this.x = x;
        this.y = y;
        this.rgb = rgb;
    }

    private int x;
    private int y;
    private int rgb;

    int x(){
        return x;
    }

    int y()
    {
        return y;
    }

    int rgb()
    {
        return rgb;
    }
}
