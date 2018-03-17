package com.tekwill;


import java.io.IOException;

import static com.tekwill.Imports.*;


public class Main {

    public static void main(String[] args) throws IOException {


       // ChemicalElement chemicalElement = new ChemicalElement(2.3, 1, 1, "Hidrogen", "H", 3);
        //System.out.println(chemicalElement.getMetalType());

        Imports x = new Imports();

        x.importMost("C:\\Users\\Sergiu\\IdeaProjects\\matrix\\periodensystem.csv");
        x.importElectro("C:\\Users\\Sergiu\\IdeaProjects\\matrix\\electronegativity.csv");



    }
}
