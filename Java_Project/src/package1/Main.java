package package1;

import java.util.Scanner;

//an enum for the regions
enum region {
 R1, // USA
 R2, // Europe
 R3, // Asia
 R4  // Africa
}

//Abstract class for car
abstract class Car {
 private String region;
 private String country;

 public Car(String region, String country) {
     this.region = region;
     this.country = country;
 }

 // Abstract method to calculate tax
 public abstract double calculateTax();
}

//Concrete implementation of Car for each region
class USACar extends Car {
 public USACar(String region, String country) {
     super(region, country);
 }

 @Override
 public double calculateTax() {
     // Tax calculation for USA
     return 90 * 0.2; // Example tax rate for USA
 }
}

class EuropeCar extends Car {
 public EuropeCar(String region, String country) {
     super(region, country);
 }

 @Override
 public double calculateTax() {
     // Tax calculation for Europe
     return 90 * 0.25; // Example tax rate for Europe
 }
}

class AsiaCar extends Car {
 public AsiaCar(String region, String country) {
     super(region, country);
 }

 @Override
 public double calculateTax() {
     // Tax calculation for Asia
     return 90 * 0.15; // Example tax rate for Asia
 }
}

class AfricaCar extends Car {
 public AfricaCar(String region, String country) {
     super(region, country);
 }

 @Override
 public double calculateTax() {
     // Tax calculation for Africa
     return 90 * 0.1; // Example tax rate for Africa
 }
}

//Factory class to create cars based on regions
class CarFactory {
 public static Car createCar(String region, String country) {
     region Region = getregion(region);
     switch (Region) {
         case R1:
             return new USACar(region, country);
         case R2:
             return new EuropeCar(region, country);
         case R3:
             return new AsiaCar(region, country);
         case R4:
             return new AfricaCar(region, country);
         default:
             throw new IllegalArgumentException("Unknown region for country: " + region);
     }
 }

 private static region getregion(String region_) {
     
     if (region_.equalsIgnoreCase("USA")) {
         return region.R1;
     } else if (region_.equalsIgnoreCase("Europe")) {
         return region.R2;
     } else if (region_.equalsIgnoreCase("Asia")) {
         return region.R3;
     } else if (region_.equalsIgnoreCase("Africa")) {
         return region.R4;
     } else {
         throw new IllegalArgumentException("Unknown Region: " + region_);
     }
 }
}

public class Main {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 String region=sc.next();
	 String country=sc.next();
	 
     Car car = CarFactory.createCar(region, country);
     System.out.println("Tax: " + car.calculateTax());
 }
}



