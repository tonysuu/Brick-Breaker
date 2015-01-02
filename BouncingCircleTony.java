import hsa.*;
import java.awt.*;

public class BouncingCircleTony {
    public static void main(String [ ]args) {
	Console c = new Console ();
	c.fillRect(0,0,640,500);
	int x = 20;
	int y = 30;
	int d = 60;
	int dx = 1;
	int dy = 1;
	
	while (true) {
	    c.setColor(Color.red);
	    c.drawOval(x,y,d,d);
	    for (int i = 0; i <= 2000000; i++) {
	    }
	    c.setColor(Color.black);
	    c.drawOval(x,y,d,d);
	    if (x + d > 639 || x < 0) {
		dx = -1 * dx;
	    }
	    if (y + d > 499 || y < 0) {
		dy = -1 * dy;
	    }
	    x = x + dx;
	    y = y + dy;
	}
    }
}
