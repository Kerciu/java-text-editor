package main.java.com.kacperpackage.Items.FontItems;

import java.awt.*;

public class CurrentFontParametersContainer {
    private String currentFontType;
    private String currentFontStyle;
    private int currentFontSize;
    private Color currentFontColor;

    public CurrentFontParametersContainer(
            String currentFontType, String currentFontStyle,
            int currentFontSize, Color currentFontColor
    ) {
        this.currentFontType = currentFontType;
        this.currentFontStyle = currentFontStyle;
        this.currentFontSize = currentFontSize;
        this.currentFontColor = currentFontColor;
    }

    public String getCurrentFontType() {
        return currentFontType;
    }

    public String getCurrentFontStyle() {
        return currentFontStyle;
    }

    public int getCurrentFontStyleAsInt() {
        return switch(currentFontStyle) {
            case "Plain" -> Font.PLAIN;
            case "Bold" -> Font.BOLD;
            case "Italic" -> Font.ITALIC;
            default -> Font.BOLD | Font.ITALIC;
        };
    }

    public int getCurrentFontSize() {
        return currentFontSize;
    }

    public Color getCurrentFontColor() {
        return currentFontColor;
    }

    public void setCurrentFontType(String currentFontType) {
        this.currentFontType = currentFontType;
    }

    public void setCurrentFontStyle(String currentFontStyle) {
        this.currentFontStyle = currentFontStyle;
    }

    public void setCurrentFontSize(int currentFontSize) {
        this.currentFontSize = currentFontSize;
    }

    public void setCurrentFontColor(Color currentFontColor) {
        this.currentFontColor = currentFontColor;
    }
}
