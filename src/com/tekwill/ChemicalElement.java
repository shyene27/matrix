package com.tekwill;

import java.util.ArrayList;
import java.util.List;

public class ChemicalElement implements Comparable<ChemicalElement> {

    private double electronegativity;
    private int period;
    private int group;
    private MetalType metalType;
    private String name;
    private String symbol;
    private int atomicNumber;

    public double getElectronegativity() {
        return electronegativity;
    }

    public int getPeriod() {
        return period;
    }

    public int getGroup() {
        return group;
    }

    public MetalType getMetalType() {
        return metalType;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public ChemicalElement(double electronegativity, int period, int group, String name, String symbol, int atomicNumber) {
        this.electronegativity = electronegativity;
        this.period = period;
        this.group = group;
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.metalType = resolveMetalType(this.atomicNumber);
    }

    MetalType resolveMetalType(int atomicNumber) {


        if (alcali(atomicNumber)) return MetalType.ALKALI;
        else if (transition(atomicNumber)) return metalType.TRANSITION;
        else if (metalsare(atomicNumber)) return metalType.METALSARE;
        else return null;



    }

    boolean alcali(int atomicNumber) {
        int[] alcali = new int[]{3, 11, 19, 37, 55, 87};
        for (int i = 0; i < alcali.length; i++) {
            if (atomicNumber == alcali[i])
                return true;
        }
        return false;

    }

    boolean transition(int atomicNumber) {
        ArrayList<Integer> range = range(21, 31);
        range.addAll(range(39, 48));
        range.addAll(range(72, 80));
        range.addAll(range(104, 112));

        for (Integer element : range) {
            if (atomicNumber == element) {
                return true;
            }

        }
        return false;
    }

    boolean metalsare (int atomicNumber){
        int[] metalsare = new int[]{13, 49, 50, 81, 82, 83, 113, 114, 115, 116};
        for (int i = 0; i < metalsare.length; i++) {
            if (atomicNumber == metalsare[i])
                return true;
        }
        return false;
    }

    ArrayList<Integer> range(int min, int max) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public String toString() {
        return "ChemicalElement{" +
                "electronegativity=" + electronegativity +
                ", period=" + period +
                ", group=" + group +
                ", metalType=" + metalType +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", atomicNumber=" + atomicNumber +
                '}';
    }


    @Override
    public int compareTo(ChemicalElement o) {
        return Double.valueOf(o.electronegativity).compareTo(Double.valueOf(this.electronegativity));
    }
}
