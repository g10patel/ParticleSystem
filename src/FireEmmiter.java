import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FireEmmiter extends Emitter {
    @Override
    public List<Particle> emit(float x, float y) {

        List<Particle> particles = new ArrayList<>();
        int numParticles = 2;
        for(int i = 0; i < numParticles; i++)
        {
            Particle particle = new Particle(x,y,new Point2D((Math.random()-0.5) * 0.65 , Math.random() * -3), 10, (float) 0.5, Color.rgb(230,40,45), BlendMode.ADD);
            particles.add(particle);
        }

        return particles;
    }
}
