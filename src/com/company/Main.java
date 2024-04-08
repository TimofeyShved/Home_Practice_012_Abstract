package com.company;

public class Main {

    public static void main(String[] args) {
        double t = 25;
        System.out.println(new Celsia().get(t));
        System.out.println(new Kelvin().get(t));
        System.out.println(new Farengate().get(t));
    }
}

// абстрактный класс (интерфейс)
interface Convert{
    double get(double znach);
}

class Celsia implements Convert{
    @Override
    public double get(double znach) {
        return znach;
    }
}

class Kelvin implements Convert{
    @Override
    public double get(double znach) {
        return znach + 273.15;
    }
}

class Farengate implements Convert{
    @Override
    public double get(double znach) {
        return (znach * 1.8) + 32;
    }
}