import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Task implements Callable<LinkedList<SetColor>> {

    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
    private int y1, y2, x1, x2;
    private int width, height;

    Task(int y1, int y2, int x1, int x2, int width, int height)
    {
        this.y1 = y1;
        this.y2 = y2;
        this.x1 = x1;
        this.x2 = x2;
        this.width = width;
        this.height = height;
    }
    public LinkedList<SetColor> call()
    {
        LinkedList<SetColor> list = new LinkedList<>();
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                zx = zy = 0;
                cX = (x - width / 2) / ZOOM;
                cY = (y - height / 2) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }

                list.add(new SetColor(x, y, iter | (iter << 8)));
            }
        }
        return list;
    }
}
