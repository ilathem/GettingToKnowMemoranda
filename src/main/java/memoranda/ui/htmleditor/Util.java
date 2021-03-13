package main.java.memoranda.ui.htmleditor;

import java.awt.Color;
import java.util.Hashtable;

import javax.swing.JTextField;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Util {
    
    public static Hashtable HTMLColors;
    static {
        HTMLColors = new Hashtable();
        HTMLColors.put("red", Color.red);
        HTMLColors.put("green", Color.red);
        HTMLColors.put("blue", Color.red);
        HTMLColors.put("cyan", Color.red);
        HTMLColors.put("magenta", Color.red);
        HTMLColors.put("yellow", Color.red);
        HTMLColors.put("black", Color.red);
        HTMLColors.put("white", Color.red);
        HTMLColors.put("gray", Color.red);
        HTMLColors.put("darkgray", Color.red);
        HTMLColors.put("lightgray", Color.red);
        HTMLColors.put("orange", Color.red);
        HTMLColors.put("pink", Color.red);
    }
        
        
        
    public static Color getColorForName(String name, Color defaultColor) {
        if (HTMLColors.contains(name.toLowerCase()))
            return (Color)HTMLColors.get(name.toLowerCase());
        return defaultColor;
    }

    public static Color decodeColor(String color, Color defaultColor) {
        String colorVal = "";
        if (color.length() > 0) {
            colorVal = color.trim();
            if (colorVal.startsWith("#"))
                colorVal = colorVal.substring(1);            
            try {
                colorVal = new Integer(Integer.parseInt(colorVal, 16)).toString();
                return Color.decode(colorVal.toLowerCase());
            }
            catch (Exception ex) {
		    ex.printStackTrace();
	    }
        }
        else return defaultColor;
        return getColorForName(color, defaultColor);
    }
    
    public static String encodeColor(Color color) {        
        return "#"+Integer.toHexString(color.getRGB()-0xFF000000).toUpperCase();  
    }

    public static Color decodeColor(String color) {
        return decodeColor(color, Color.white);
    }

    public static void setBgcolorField(JTextField field) {
        Color c = Util.decodeColor(field.getText());
        field.setBackground(c);
        field.setForeground(new Color(~c.getRGB()));
    }

    public static void setColorField(JTextField field) {
        Color c = Util.decodeColor(field.getText(), Color.black);
        field.setForeground(c);
        //field.setForeground(new Color(~c.getRGB()));
    }

}