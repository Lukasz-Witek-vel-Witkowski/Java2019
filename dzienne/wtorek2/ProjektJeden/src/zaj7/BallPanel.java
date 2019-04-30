package zaj7;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Krzysztof Podlaski on 16.04.2019.
 */
public class BallPanel extends JPanel {
    Ball ball, ball2;
    private Animation animation;

    public BallPanel(Ball ball, Ball ball2) {
        this.ball = ball;
        this.ball2=ball2;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        ball.draw(g);
        ball2.draw(g);
    }

    public void update(){
        ball.move();
        ball2.move();
    }
    public void checkColisons(){
        ball.checkColisionWithBorder(
                getWidth(), getHeight()
        );
        ball2.checkColisionWithBorder(
                getWidth(), getHeight()
        );
        ball.checkColisionWihBall(ball2);

    }

    public void startAnimation(){
        animation = new Animation();
        Thread t = new Thread(animation);
        t.start();
    }
    public void stopAnimation(){
        animation.stop_animation=true;
    }


    class Animation implements Runnable{

        private boolean stop_animation = false;

        @Override
        public void run() {
            while(!stop_animation){
                update();
                checkColisons();
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Ball ball = Ball.create(
                "zaj7/ball.jpg",130,80,40);
        Ball ball2 = Ball.create(
                "zaj7/ball.jpg",60,30,20);
        BallPanel bPanel = new BallPanel(ball,ball2);
        JFrame frame = new JFrame("Anmimacja");
        frame.setContentPane(bPanel);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        bPanel.startAnimation();
    }



}
