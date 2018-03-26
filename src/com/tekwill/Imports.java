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

                lines2.put(Byte.valueOf(values[0]), lineList);

            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Method for importing electronegativity
    public List<ChemicalElement> importElectro(String fileName) {
        File file2 = new File(fileName);

        Scanner inputStream2 = null;

        List<ChemicalElement> chemicalElements = new ArrayList<>();

        try {
            inputStream2 = new Scanner(file2);

            while (inputStream2.hasNext()) {
                String line = inputStream2.next();
                String[] values = line.split(",");


                byte id = Byte.parseByte(values[0]);

                List<String> objLineFromFirstFile = lines2.get(id);
                if(objLineFromFirstFile!=null) {
                    ChemicalElement chemicalElement = new ChemicalElement(Double.valueOf(values[3]), Integer.valueOf(objLineFromFirstFile.get(4)),
                            Integer.valueOf(objLineFromFirstFile.get(3)), objLineFromFirstFile.get(1), objLineFromFirstFile.get(2), id);

                    chemicalElements.add(chemicalElement);

                }


            }
            inputStream2.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        }

return chemicalElements;
    }

}


