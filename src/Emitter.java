import java.util.List;

public abstract class Emitter {

    public abstract Particle[] emit(float x, float y, int numParticles);

    public abstract Particle newParticle(float x, float y);
}
