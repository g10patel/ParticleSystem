import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class UniversalEmitter extends Emitter {
    @Override
    public Particle[] emit(float x, float y, int numParticles) {

        Particle[] particles = new Particle[numParticles];
        //List<Particle> particles = new ArrayList<>();


        //int numParticles = 90;
        for(int i = 0; i < numParticles; i++)
        {
            Particle particle = new Particle((float) (Math.random() * (x)), (float) (Math.random()*(y)),new Point2D((Math.random()-0.5) * 0.65 , Math.random() * -3), 10, Color.rgb(230,40,45), BlendMode.ADD);
            particles[i] = particle;
        }

        //System.out.println(particles.length);
        return particles;
    }

    public Particle newParticle(float x, float y)
    {
        return new Particle((float) (Math.random() * (x)), (float) (Math.random()*(y)),new Point2D((Math.random()-0.5) * 0.65 , Math.random() * -3), 10, Color.rgb(230,40,45), BlendMode.ADD);
    }

}
