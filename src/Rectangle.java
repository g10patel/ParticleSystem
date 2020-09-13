import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Rectangle {
    float x;
    float y;
    float width;
    float height;
    Paint color;

    private Point2D velocity;


    public Rectangle(float x, float y, Paint color, float width, float height, Point2D velocity) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    public void render(GraphicsContext g)
    {

        g.fillRect(x,y,width,height);
        g.setFill(color);
    }

    public void update()
    {
        x += velocity.getX();
        if(atBorder())
        {
            if(x > 1) {
                velocity = new Point2D(velocity.getX() - 10, 0);
            }
            else
            {
                velocity = new Point2D(velocity.getX() + 10, 0);
            }
        }
    }

    private boolean atBorder()
    {
        if(x + width == 600) {
            return true;
        }
        if(x < 0)
        {
            return true;
        }
        if(y < 0)
        {
            return true;
        }
        if(y + height == 600)
        {
            return true;
        }
        return false;

    }

    public void collisionFire(Particle a, GraphicsContext g)
    {
        float RightBound = x + width;
        float BottomBound = y + height;

        if(a.x > x && a.x < RightBound && a.y > y && a.y < BottomBound)
        {
            color = Color.BLUE;
        }
        color = Color.RED;

    }



}
