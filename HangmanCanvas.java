import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class HangmanCanvas extends JPanel {
    //gamestate variable
    private GameState gameState;

    //constructor for the gamestae
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        //redraws the canvas
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameState == null) return;

        Graphics2D g2 = (Graphics2D) g;
        //draws the gallows and background
        if (gameState.getMistakesCounter() >= 0) {
            drawBackground(gameState, g2);
            drawGallows(gameState, g2);
        }
        //draws the head if the mistake counter increments to 1
        if (gameState.getMistakesCounter() >= 1) {
            drawHead(gameState, g2);
        }
        //draws the body if the mistake counter increments to 2
        if (gameState.getMistakesCounter() >= 2) {
            drawBody(gameState, g2);
        }
        //draws the left arm if the mistake counter increments to 3
        if (gameState.getMistakesCounter() >= 3) {
            drawLeftArm(gameState, g2);
        }
        //draws the left leg if the mistake counter increments to 4
        if (gameState.getMistakesCounter() >= 4) {
            drawLeftLeg(gameState, g2);
        }
        //draws the Right Leg if the mistake counter increments to 5
        if (gameState.getMistakesCounter() >= 5) {
            drawRightLeg(gameState, g2);
        }
        //draws the Right Arm if the mistake counter increments to 6
        if (gameState.getMistakesCounter() >= 6) {
            drawRightArm(gameState, g2);
        }
    }

    public void drawBackground(GameState gs, Graphics2D g2){
        //black background
        Rectangle2D.Double h = new Rectangle2D.Double(0, 0, 4000, 1000);
        // setColor tells g2 what to color everything until called again
        g2.setColor(Color.BLACK);
        // g2.fill() fills the area defined by the shape
        g2.fill(h);
        //setColor allows to adjust custom RGB values
    }

    //method draws the gallows
    public void drawGallows(GameState gs, Graphics2D g2) {
        //base of the gallows
        g2.setColor(new Color(255, 255, 255));
        g2.drawLine(300, 500, 1000, 500);

        //vertical beam of the gallows
        g2.setColor(new Color(255, 255, 255));
        g2.drawLine(630, 500, 630, 70);

        //top crossbeam of the gallows
        g2.setColor(new Color(255, 255, 255));
        g2.drawLine(825, 70, 630, 70);

        //Lower vertical hook
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(825, 70, 825, 100);
    }

    public void drawHead(GameState ng, Graphics2D g2) {
        //head
        Ellipse2D.Double c = new Ellipse2D.Double(795, 90, 60, 60);
        //setColor allows to adjust custom RGB values
        g2.setColor(new Color(255, 255, 255));
        // g2.fill() fills the area defined by the shape
        g2.fill(c);
        // g2.draw() defines the outline made by the shape
        g2.draw(c);
    }

    //method draws the body
    public void drawBody(GameState ng, Graphics2D g2) {
        //Body
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(825, 100, 825, 250);
    }
    //method draws the left arm
    public void drawLeftArm(GameState ng, Graphics2D g2) {
        //Left Arm
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(730, 150, 825, 160);

    }
    //Method draws the left leg
    public void drawLeftLeg(GameState ng, Graphics2D g2) {
        //left leg
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(750, 350, 825, 250);


    }
    //method draws the right leg
    public void drawRightLeg(GameState ng, Graphics2D g2) {
        // right leg
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(910, 350, 825, 250);

    }
    //method draws the right arm
    public void drawRightArm(GameState ng, Graphics2D g2) {
        //right arm
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.drawLine(920, 150, 825, 160);
    }
}