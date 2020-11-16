import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Calculator extends JFrame implements ActionListener
{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private static final int FRAME_X = 150;
    private static final int FRAME_Y = 100;

    private JPanel buttonPanel;
    private JPanel inputOutputPanel;

    private JTextField info;

    private boolean editable = true;

    public Calculator()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4,5,5));
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));

        inputOutputPanel = new JPanel();
        inputOutputPanel.setLayout(new FlowLayout());
        inputOutputPanel.setBorder(new EmptyBorder(10,10,10,10));

        setTitle("Calculator using Java");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setLocation(FRAME_X,FRAME_Y);

        info = new JTextField();
        info.setFont(new Font("SansSerif", Font.PLAIN, 16));
        info.setBackground(Color.white);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setPreferredSize(new Dimension(270, 35));
        info.addActionListener(this);
        inputOutputPanel.add(info);
        contentPane.add(inputOutputPanel);

        String buttons[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2","3","-","0",".","=", "+",};

        for (String i : buttons)
        {
            JButton button = new JButton(i);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        contentPane.add(buttonPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() instanceof JButton)
        {
            JButton clickedButton = (JButton) event.getSource();
            if(clickedButton.getText().equals("="))
            {
                addOutput();
            }
            else
            {
                addInput(clickedButton.getText());
            }
        }
        else
        {
            addOutput();
        }
    }

    public void addInput(String line)
    {
        if(editable)
        {
            info.setText(info.getText()+line);
        }
        else
        {
            info.setText(line);
            editable = true;
        }
    }
    public void addOutput()
    {
        double output = 0;
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            info.setText(engine.eval(info.getText()).toString());
        }
        catch(ScriptException e)
        {
            info.setText("Syntax error");
        }
        editable = false;
    }

    public static void main (String [] args)
    {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}