# Абстрактные классы и интерфейсы 

6.0. Конвертер температур

Задача
--------

Напишите класс BaseConverter для конвертации из градусов по Цельсию в
Кельвины, Фаренгейты, и так далее. У класса должен быть метод convert, который
и делает конвертацию.

Решение:
--------
    interface Converter {
        double getConvertedValue(double baseValue);
    }
    
    class CelsiusConverter implements Converter {
        @Override
        public double getConvertedValue(double baseValue) {
            return baseValue;
        }
    }
    
    class KelvinConverter implements Converter {
        @Override
        public double getConvertedValue(double baseValue) {
            return baseValue + 273.15;
        }
    }
    
    class FahrenheitConverter implements Converter {
        @Override
        public double getConvertedValue(double baseValue) {
            return 1.8 * baseValue + 32;
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            double temperature = 23.5;
            System.out.println("t = " + 
                    new CelsiusConverter().getConvertedValue(temperature));
            System.out.println("t = " + 
                    new KelvinConverter().getConvertedValue(temperature));
            System.out.println("t = " + 
                    new FahrenheitConverter().getConvertedValue(temperature));
        }
    }

Дополнительно можно попросить реализовать фабричный метод, как-то так:

    interface Converter {
        double getConvertedValue(double baseValue);
    
        public static Converter getInstance(){
            Locale locale = Locale.getDefault();
            String[] fahrenheitCountries = {"BS", "US", "BZ", "KY", "PW"};
    
            boolean isFahrenheitCountry = 
                    Arrays.asList(fahrenheitCountries).contains(locale.getCountry());
    
            if(isFahrenheitCountry){
                return new FahrenheitConverter();
            } else {
                return new CelsiusConverter();
            }
        }
    }