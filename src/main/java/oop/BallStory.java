package oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Fox fox = new Fox();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        hare.tryEat(ball.tryRun(false));
        wolf.tryEat(ball.tryRun(false));
        fox.tryEat(ball.tryRun(true));
    }
}
