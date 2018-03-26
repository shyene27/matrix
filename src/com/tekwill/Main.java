package com.tekwill;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.tekwill.Imports.*;


public class Main {

    public static void main(String[] args) throws IOException {


       // ChemicalElement chemicalElement = new ChemicalElement(2.3, 1, 1, "Hidrogen", "H", 3);

        Imports x = new Imports();

        x.importMost("C:\\Users\\Sergiu Cretu\\IdeaProjects\\matrix\\periodensystem.csv ");

        List<ChemicalElement> boraBora = x.importElectro("C:\\Users\\Sergiu Cretu\\IdeaProjects\\matrix\\electronegativity.csv");


        Collections.sort(boraBora,(e1,e2)-> e2.getAtomicNumber()-e1.getAtomicNumber());

        for (ChemicalElement element: boraBora) {

            System.out.println(element.toString());

        }
    }
}
