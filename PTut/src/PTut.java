
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class PTut {
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(1000, 600, false);
        app.setTargetFrameRate(60);
        app.start();
    }
}
