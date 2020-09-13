
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Particle {

    public float x;
    public float y;

    private Point2D velocity;

    private float radius;
    private float life = 1;
    private float decay;

    private Paint color;
    private BlendMode blendMode;

    public Particle(float x, float y, Point2D velocity, float radius, float expireTime, Paint color, BlendMode blendMode) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.radius = radius;
        this.decay = (float) (0.016/expireTime);
        this.color = color;
        this.blendMode = blendMode;
    }


    public void update()
    {
        x+= velocity.getX();
        y+= velocity.getY();

        life -= decay;

    }

    public void render(GraphicsContext g)
    {
        g.setGlobalAlpha(life);
        g.setGlobalBlendMode(blendMode);
        g.setFill(color);
        g.fillOval(x,y,radius,radius);
    }

    public boolean isAlive()
    {
        return life > 0;
    }




}
