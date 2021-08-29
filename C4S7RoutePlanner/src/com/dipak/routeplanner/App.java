package com.dipak.routeplanner;

import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        FilghtInformation filghtInformation=new FilghtInformation();
        String fileInput="E:\\Stackroute\\Repository\\c4-project1-route-planner\\C4S7RoutePlanner\\src\\resources\\routes.csv";
        int countFlights=filghtInformation.displayFlight(fileInput);
        Route[] flightRoutes=filghtInformation.flightData(fileInput,countFlights);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("\nEnter your Source city :: ");
        Scanner scanner=new Scanner(System.in);
        String fromCity=scanner.next();

        Route[] directFlightInformation=filghtInformation.showDirectFlights(flightRoutes,fromCity);
        if(directFlightInformation.length==0)
        {
            System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from :: "+fromCity.toUpperCase());
        }
        else
        {
            for(Route directFlight :directFlightInformation)
            {
                System.out.format("\n%10s %10s %10s %10s %15s",directFlight.getSource(),directFlight.getDestination(),directFlight.getDistance(),directFlight.getTime(),directFlight.getPrice());
            }
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        Route[] sortDirectFlights=filghtInformation.sortDirectFlights(directFlightInformation);
        System.out.println("-------------------------------------------Sorted Flight----------------------------------");
        for (Route sortedList : sortDirectFlights)
            System.out.format("\n%10s %10s %10s %10s %15s",sortedList.getSource(),sortedList.getDestination(),sortedList.getDistance(),sortedList.getTime(),sortedList.getPrice());
        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("\nEnter source city :: ");
        String sourceCity=scanner.next();
        System.out.println("\nEnter destination city :: ");
        String destinationCity=scanner.next();
        filghtInformation.showAllFlightConnection(flightRoutes,sourceCity,destinationCity);
    }
}
