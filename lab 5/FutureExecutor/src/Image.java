import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Image extends JFrame {

    private BufferedImage image;
    private final double ZOOM = 150;
    int x;
    int y;
    int height;
    int width;

    public Image(int x, int y, int height, int width)
    {
        super("Task Set");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


        setBounds(x, y, width, height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public BufferedImage getImage()
    {
        return image;
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void setRGB(SetColor s)
    {
        image.setRGB(s.x(), s.y(), s.rgb());
    }
}
