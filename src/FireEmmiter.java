import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FireEmmiter extends Emitter {
    @Override
    public Particle[] emit(float x, float y, int numParticles) {

        Particle[] particles = new Particle[numParticles];

        for(int i = 0; i < numParticles; i++)
        {
            Particle particle = new Particle(x,y,new Point2D((Math.random()-0.5) * 0.65 , Math.random() * -3), 10, Color.rgb(230,40,45), BlendMode.ADD);
            particles[i] = particle;
        }

        return particles;
    }

    @Override
    public Particle newParticle(float x, float y) {
        return new Particle(x,y,new Point2D((Math.random()-0.5) * 0.65 , Math.random() * -3), 10, Color.rgb(230,40,45), BlendMode.ADD);
    }
}
