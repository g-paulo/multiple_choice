package Archivos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui {
    private JPanel windowContent, panelAnswer;
    private JLabel answers, qLabel, showQLabel;
    private JButton check;

    public Gui(int size, int numQuestion, ArrayList<String> questions, ArrayList<JRadioButton> rButtons) {
        // Setea el layout para este panel
        windowContent = new JPanel();
        BorderLayout bl = new BorderLayout();

        windowContent.setLayout(bl);

        // Creamos el panel con una grilla
        panelAnswer = new JPanel();
        qLabel = new JLabel("Preguntas");
        GridLayout gl = new GridLayout(size + 4,1);

        panelAnswer.setLayout(gl);
        panelAnswer.add(qLabel);

        // Creamos y agregamos el campo de texto para las preguntas
        showQLabel = new JLabel(questions.get(numQuestion));
        answers = new JLabel("Respuestas");

        panelAnswer.add(showQLabel);
        panelAnswer.add(answers);

        // Agregamos los botones a la ventana al panelAnswer
        for (int i = 0; i < rButtons.size(); i++)
            panelAnswer.add(rButtons.get(i));

        // Agregamos un grupo de botones para los radio buttons
        ButtonGroup bg = new ButtonGroup();

        for (int i = 0; i < rButtons.size(); i++)
            bg.add(rButtons.get(i));

        // Agregamos al panel el boton para responder
        check = new JButton("Responder");
        panelAnswer.add(check);

        // Agregamos el panelAnswer al centro del area de la ventana
        windowContent.add("Center",panelAnswer);

        // Creamos y seteamos el contenido de pane
        JFrame frame =  new JFrame("Test");
        frame.setContentPane(windowContent);
        // Fijamos el tamaño de la ventana para que se acomoden todos los botones
        frame.pack();
        // Mostramos la ventana
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public JButton getCheck() {
        return check;
    }

    public JLabel getShowQuestions(){
        return showQLabel;
    }
}
