package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_VehicleCatalogue {
    static class Vehicle{
        private String type;
        private String model;
        private String color;
        private int horsepower;

        Vehicle(String type, String model, String color, int horsepower){
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getModel() {return model;}

        public boolean isThisModel(String model){
            return this.model.equals(model);
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    this.type,
                    this.model,
                    this.color,
                    this.horsepower
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        double averageHorsePowerCar = 0;
        double averageHorsePowerTruck = 0;
        int countCar = 0;
        int countTruck = 0;
        List<Vehicle> listVehicle = new ArrayList<>();


        while (!input[0].equals("End")) {
            listVehicle.add(new Vehicle(input[0], input[1], input[2], Integer.parseInt(input[3])));
            if (input[0].equals("car")) {
                averageHorsePowerCar += Double.parseDouble(input[3]);
                countCar++;
            }else if(input[0].equals("truck")){
                averageHorsePowerTruck += Double.parseDouble(input[3]);
                countTruck++;
            }
            input = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();
        while (!command.equals("Close the Catalogue")) {
            for (Vehicle vehicle : listVehicle)
                if (vehicle.getModel().equals(command))
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n",
                            vehicle.type.substring(0, 1).toUpperCase()+ vehicle.type.substring(1),
                            vehicle.model, vehicle.color, vehicle.horsepower);

            command = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n",countCar!=0?averageHorsePowerCar/countCar:0);
        System.out.printf("Trucks have average horsepower of: %.2f.",countTruck!=0?averageHorsePowerTruck/countTruck:0);
    }
}