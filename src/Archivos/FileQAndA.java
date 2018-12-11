package Archivos;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileQAndA {
    // Example in FileRender's parameter "/home/user/desktop/questiones.txt"
    private final BufferedReader brQ = new BufferedReader(new FileReader(/* path for questiones */));
    // Example in FileRender's parameter "/home/user/desktop/answers.txt"
    private final BufferedReader brA = new BufferedReader(new FileReader(/* path for answers */));
    // Example in FileRender's parameter "/home/user/desktop/correct_answers.txt"
    private final BufferedReader brT = new BufferedReader(new FileReader(/* path for correct answers */));
    private final ArrayList<String> linesQ,linesA,linesT;
    private String line;

    public FileQAndA() throws IOException {
        linesQ = new ArrayList<>();
        linesA = new ArrayList<>();
        linesT = new ArrayList<>();

        while ((line = brQ.readLine()) != null){
            linesQ.add(line);
        }

        while ((line = brA.readLine()) != null){
            linesA.add(line);
        }

        while ((line = brT.readLine()) != null){
            linesT.add(line);
        }
    }

    public void setTable(Hashtable<String, Integer> table) throws IOException {
        for (int i = 0; i < linesQ.size() && i < linesT.size(); i++)
            table.put(linesQ.get(i), Integer.parseInt(linesT.get(i)));
    }

    public void setQuestions(ArrayList<String> questions) throws IOException {
        for (int i = 0; i < linesQ.size(); i++)
            questions.add(linesQ.get(i));
    }

    public void setRadioButtons(ArrayList<JRadioButton> radioButton) throws IOException {
       for (int i = 0; i < linesA.size(); i++)
            radioButton.add(new JRadioButton(linesA.get(i)));
    }
}
