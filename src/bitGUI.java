import acm.graphics.GCanvas;
import acm.program.Program;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class bitGUI extends Program
{
    private JTextField inputField;
    private JTextField shortField;
    private JLabel hashResult;

    public bitGUI()
    {
        start();
    }

    public void init()
    {
        JLabel inputLabel = new JLabel("URL");
        JLabel shortLabel = new JLabel("Short");
        JLabel hashLabel = new JLabel("Hash");

        GCanvas canvas = new GCanvas();
        this.add(canvas);

        canvas.add(inputLabel, 20, 20);
        canvas.add(shortLabel, 20, 50);
        canvas.add(hashLabel, 20, 80);

        inputField = new JTextField();
        inputField.setSize(300, 20);
        canvas.add(inputField, 50, 20);

        JButton goButton = new JButton("Go");
        canvas.add(goButton, 350, 20);

        JButton clearButton = new JButton("Clear");
        canvas.add(clearButton, 400, 20);

        shortField = new JTextField();
        shortField.setSize(300, 20);
        canvas.add(shortField, 50, 50);

        hashResult = new JLabel("   ");
        canvas.add(hashResult, 50, 80);

        addActionListeners();
    }

    public static void main(String[] args)
    {
        bitGUI g= new bitGUI();
    }

    public void actionPerformed(ActionEvent ae)
    {
        String whichButton = ae.getActionCommand();

        switch (whichButton)
        {
            case "Go":
                Bitly b = new Bitly(inputField.getText());
                shortField.setText(b.getShortUrl());
                hashResult.setText(b.getHash());

                hashResult.setSize(hashResult.getPreferredSize());
                break;

            case "Clear":
                inputField.setText("");
                shortField.setText("");
                hashResult.setText("");
                break;

        }
    }
}