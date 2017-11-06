import acm.graphics.GCanvas;
import acm.program.Program;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GUI extends Program
{
    private JTextField inputField;
    private JTextField locationField;
    private JTextField weatherField;
    private JTextField tempField;

    public GUI()
    {
        start();
    }

    public void init()
    {
        JLabel inputLabel = new JLabel("Zip Code");
        JLabel locationLabel = new JLabel("Location");
        JLabel weatherLabel = new JLabel("Forecast");
        JLabel tempLabel = new JLabel("Temperature");

        GCanvas canvas = new GCanvas();
        this.add(canvas);

        canvas.add(inputLabel, 20, 20);
        canvas.add(locationLabel, 20, 60);
        canvas.add(weatherLabel, 20, 100);
        canvas.add(tempLabel, 20, 140);

        inputField = new JTextField();
        inputField.setSize(300, 20);
        canvas.add(inputField, 80, 20);

        JButton goButton = new JButton("Go");
        canvas.add(goButton, 380, 20);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 430, 20);

        locationField = new JTextField();
        locationField.setSize(300, 20);
        canvas.add(locationField, 80, 60);
        locationField.setEditable(false);

        weatherField = new JTextField();
        weatherField.setSize(300, 20);
        canvas.add(weatherField, 80, 100);
        weatherField.setEditable(false);

        tempField = new JTextField();
        tempField.setSize(280, 20);
        canvas.add(tempField, 100, 140);
        tempField.setEditable(false);

        addActionListeners();
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }

    public void actionPerformed(ActionEvent ae)
    {
        String whichButton = ae.getActionCommand();

        switch (whichButton)
        {
            case "Go":
                Weather w = new Weather(inputField.getText());
                locationField.setText(w.getCityState());
                weatherField.setText(w.getWeather());
                tempField.setText(w.getTemperature());
                break;

            case "Clear":
                inputField.setText("");
                locationField.setText("");
                weatherField.setText("");
                tempField.setText("");
                break;
        }
    }
}
