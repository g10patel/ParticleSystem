import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ParticlesApp extends Application {

    private Emitter emitter = new UniversalEmitter();
    private int numParticles = 10;

    private Particle[] particles = new Particle[numParticles * 32];

    private GraphicsContext g;

    Rectangle a = new Rectangle(250, 499, Color.BLUE, 100, 100, new Point2D(10, 0));
    private void onUpdate() {
        g.setGlobalAlpha(1.0);
        g.setGlobalBlendMode(BlendMode.SRC_OVER);
        g.setFill(Color.BLACK);
        g.fillRect(0,0,600,600);

        System.out.println(particles.length);
        for (int i  = 0 ; i < particles.length; i++)
        {
            Particle p = particles[i];
            p.update();
            if(!p.isAlive())
            {
                particles[i] = emitter.newParticle(600, 600);
            }
            p.render(g);
        }

    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600,600);

        Canvas canvas = new Canvas(600,600);

        g = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
        populateParticle();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                onUpdate();
            }
        };
        timer.start();

    }

    private void populateParticle() {
        for(int i = 1; i < 33; i++)
        {
            int tmp = i * numParticles;
            int count = 0;
            for(int j  = tmp - numParticles ; j < tmp; j++)
            {
                Particle[] particle = emitter.emit(600,600,numParticles);
                System.out.println(j);
                particles[j] = particle[count];
                count++;
            }

        }
    }


    public static void main (String[] args)

    {
        launch(args);
    }
}
