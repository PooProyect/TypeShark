/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author fabkm
 */
public class BallenaG {
    private Canvas ballena;
    
    public BallenaG(){
        ballena = new Canvas(220,120);
        this.desingBallena(Color.CORAL);
    }
    
    public Node getBallena(){
        return ballena;
    }
    
    private void desingBallena(Color color){
        double xPoints[] = {5,5,15,25,35,50,65,90,120,150,170,188,192,80};  //13
        double yPoints[] = {60,50,45,40,35,30,28,27,30,40,46,45,55,100};  //*
        double xPon[] = { 5,10,30,50,90,100,110,120,125,120,110,130,150,175,190,195,185,160,130,100, 60,40,30,20,10, 5};  //26
        double yPon[] = {60,60,62,64,60, 56, 52, 55, 60, 70, 75, 70, 65, 60, 55, 65, 70, 85, 95,100,100,99,95,87,80,70};
        double xAleta[] = {60,55,58, 65, 75, 85, 95, 93,90,85,80,90};  //12
        double yAleta[] = {60,80,90,100,110,120,110,100,90,80,70,50};  //*
        double xCola[] = {185,186,190,200,205,202,200,199,205,212,215,220,215,210,200,195,190};  //*
        double yCola[] = { 40, 30, 20, 15, 20, 30, 40, 45, 55, 60, 65, 70, 75, 74, 70, 65, 55};   //*
        double xAla[] = {90,110,130,128,120}; //*
        double yAla[] = {32,10,0,5,32};
        double xBoca[] = {4,30,5};  //*
        double yBoca[] = {54,53,72}; //*
        double xInf[] = {135,155,150};
        double yInf[] = {68,63,90};
        
        GraphicsContext ball = ballena.getGraphicsContext2D();
        //tibu.strokeText("TiburonN",10,10);
        
        ball.setFill(Color.BLACK);
        //tibu.fillPolygon(xPoints, yPoints, nPoints);
        ball.fillPolygon(xPoints, yPoints, 14);
        ball.fillPolygon(xAla, yAla, 5);
        ball.fillPolygon(xCola, yCola, 17);
        //ball.fillPolygon(xCola, yColaN, 3);
        //ball.fillPolygon(xInf, yInf, 3);
        
        
        ball.setFill(Color.WHITE);
        ball.fillPolygon(xPon, yPon, 26);
        ball.fillOval(30, 45, 25, 15);
        ball.setFill(Color.BLACK);
        ball.fillPolygon(xAleta, yAleta, 12);
        ball.fillOval(37, 53, 5, 5);
//tibu.fillArc(x, y, w, h, startAngle, arcExtent, ArcType.CHORD);
       /* ball.fillArc(5, 30,168,73,0,180,ArcType.ROUND);
        ball.fillArc(5, 30,168,43, 0, -180, ArcType.ROUND);
        //tibu.fillOval(x, y, w, h);
        ball.fillOval(3, 25, 130, 50);  //*
        //tibu.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
        //tibu.strokeRoundRect(15, 40, 5, 5, 10, 10);
        
        ball.setFill(Color.WHITESMOKE);
        ball.fillOval(18, 38, 10, 10);
        
        ball.setFill(Color.BLACK);
        
        ball.fillOval(20, 42, 5, 5);
        
        ball.setFill(color);
        ball.fillPolygon(xBoca, yBoca, 3);
        //tibu.closePath();  */
    }
    
}
