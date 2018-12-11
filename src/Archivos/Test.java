package Archivos;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class Test {
    private ArrayList<String> questions;
    private ArrayList<JRadioButton> rButtons;
    private final Hashtable<String, Integer> TABLE;
    private static int numQuestion = 0, rate = 0;


    public Test() throws IOException{
        FileQAndA fileQAndA = new FileQAndA();
        // Tabla con las respuestas correctas
        TABLE  = new Hashtable();
        fileQAndA.setTable(TABLE);

        // Crea y Carga las preguntas y los radio buttons en sus respectivas listas
        questions = new ArrayList();
        rButtons = new ArrayList();
        fileQAndA.setQuestions(questions);
        fileQAndA.setRadioButtons(rButtons);

        Gui gui = new Gui(rButtons.size(), numQuestion, questions, rButtons);

        gui.getCheck().addActionListener(actionEvent -> {
            int rIdx = this.radio_r_selected();

            if (TABLE.get(questions.get(numQuestion)) == rIdx) {
                JOptionPane.showMessageDialog(null,"+1!");
                this.rate++;
            }

            if (numQuestion + 1 >= questions.size()) {
                JOptionPane.showMessageDialog(null, "Obtubo un total de: " + rate + " puntos.");
                JOptionPane.showMessageDialog(null, "Muchas gracias por respoder las preguntas.");
                System.exit(0);
            }
            gui.getShowQuestions().setText(questions.get(++numQuestion));
        });
    }

    private int radio_r_selected() {
        int i = 0;
        for (; i < rButtons.size(); i++)
            if (rButtons.get(i).isSelected())
                break;
        return i;
    }
}
