/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntruccionHTML;

import java.awt.Color;

/**
 *
 * @author EG
 */
public class LibreriaColor {
    public Color traducirColor(String nombreColor){
        switch(nombreColor.toLowerCase()){
            case "red":
               return Color.RED;
            case "blue":
               return Color.BLUE;
            case "yellow":
               return Color.YELLOW; 
            case "gray":
                return Color.GRAY;
            case "pink":
                return Color.PINK;
            case "orange":
                return Color.ORANGE;
            case "purple":
                return Color.white;
            case "magenta":
                return Color.MAGENTA;
            case "green":
                return Color.green;
            case "brown":
                return Color.BLACK;
            case "black":
                return Color.BLACK;
            case "light":
                return Color.BLUE.brighter();
            default:
                return Color.gray;
               
        }
    }
    public Color traducirColor(int r,int g, int b){
        return new Color(r,g,b);
    }
}
