package com.tekwill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Imports {

    List<List<String>> lines = new ArrayList<>();

    Map<Byte,List<String>> lines2 = new HashMap<>();


    //Method for importing every element data except electronegativity
    public void importMost(String fileName) {
        File file = new File(fileName);


        Scanner inputStream;

        try {
            inputStream = new Scanner(file);

            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(";");
                ArrayList<String> lineList = new ArrayList<>(Arrays.asList(values));
                lines.add(lineList);

                lines2.put(id,value);

            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Method for importing electronegativity
    public void importElectro(String fileName) {
        File file2 = new File(fileName);

        Scanner inputStream2 = null;

        try {
            inputStream2 = new Scanner(file2);

            while (inputStream2.hasNext()) {
                String line = inputStream2.next();
                String[] values = line.split(",");

               // for (int i=0; i<lines.size(); i++) {
                //    lines.get(i).add(values[3]);
                //}
                byte id = values[id];

                List<String> objLineFromFirstFile = lines2.get(id);
                ChemicalElement chemicalElement = new ChemicalElement(values[electronegativity], period, group, name, symbol, id);

            }
            inputStream2.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        }
        // the following code lets you iterate through the 2-dimensional array

        for (List<String> line : lines) {
            System.out.println("");
            for (String value : line) {
                System.out.print(value + "\t");

            }
        }

    }


}


