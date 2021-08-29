package com.dipak.routeplanner;

import java.io.*;

public class FilghtInformation
{
    public int displayFlight(String fileInput)
    {
        int countFlight=0;
        try
        {
            FileInputStream inputStream=new FileInputStream(fileInput);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String dataFile;
            //System.out.format("%10s %10s %10s %10s %15s","From City","To City","Distance in km","Travel Time","Typical Airfare");
            while((dataFile=bufferedReader.readLine())!=null)
            {
                countFlight++;
                String[] flightData=dataFile.split(",");
                System.out.format("\n%10s %10s %10s %10s %15s",flightData[0],flightData[1],flightData[2],flightData[3],flightData[4]);
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(exception.toString());
        }
        catch (IOException  exception)
        {
            System.out.println(exception.toString());
        }
        return countFlight;
    }

    public Route[] flightData(String fileInput, int countFlight)
    {
        int count=0;
        Route[] flightRoute=new Route[countFlight];
        try
        {
            FileInputStream fileInputStream=new FileInputStream(fileInput);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String data;
            while((data=bufferedReader.readLine())!=null)
            {
                String[] details=data.split("[, ]+");
                flightRoute[count]=new Route(details[0],details[1],details[2],details[3],details[4]);
                count++;
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(exception.toString());
        }
        catch (IOException exception)
        {
            System.out.println(exception.toString());
        }
        return flightRoute;
    }
    public Route[] showDirectFlights(Route[] routes, String fromCity)
    {
        Route[] directFlight;
        int j=0;
        int count=0;
        for (int i=0;i<routes.length;i++)
        {
            if(fromCity.equalsIgnoreCase(routes[i].getSource()))
            {
                count++;
            }
        }
        directFlight=new Route[count];
        for (int i=0;i<routes.length;i++)
        {
            if(fromCity.equalsIgnoreCase(routes[i].getSource()))
            {
                directFlight[j]=routes[i];
                j++;
            }
        }
        return directFlight;
    }

    public Route[] sortDirectFlights(Route directFlights[])
    {
        for (int i=0;i<directFlights.length;i++)
        {
            for(int j=0;j<directFlights.length-1-i;j++)
            {
                String destinationCity1=directFlights[j].getDestination();
                String destinationCity2=directFlights[j+1].getDestination();
                if(destinationCity1.compareToIgnoreCase(destinationCity2)>0)
                {
                    Route tempFlights=directFlights[j];
                    directFlights[j]=directFlights[j+1];
                    directFlights[j+1]=tempFlights;
                }
            }
        }
        return directFlights;
    }

    public Route[] showAllFlightConnection(Route[] routes, String fromCity, String toCity)
    {
        Route[] allFlight=showDirectFlights(routes,fromCity);
        System.out.println("--------------All Direct Flights------------------");
        for (Route route : allFlight)
        {
            if (toCity.equalsIgnoreCase(route.getDestination().trim()))
            {
                System.out.println(route.getSource().trim() + "\t" + route.getDestination().trim() +
                        "\t" + route.getDistance().trim() + "\t" + route.getTime().trim() + "\t" + route.getPrice().trim());
            }
        }
        System.out.println();
        System.out.println("--------------Alternative Flights"+fromCity+" to "+toCity+ "------------------");
        for(int i=0;i< allFlight.length;i++)
        {
            String temp=routes[i].getDestination().trim();

            if (fromCity.equalsIgnoreCase(routes[i].getSource().trim()) && !toCity.equalsIgnoreCase(temp))
            {
                for(int j=0;j< routes.length;j++)
                {
                    if(temp.equalsIgnoreCase(routes[j].getSource().trim()) && routes[j].getDestination().trim().equalsIgnoreCase(toCity))
                    {
                        System.out.println("\nFrom = "+allFlight[i].getSource()+"\t"+" To = "+allFlight[i].getDestination()+"\t"+" Distance = "+allFlight[i].getDistance()+
                                "\t"+"Time taken ="+allFlight[i].getTime()+"\t"+" Typical Airfare = "+allFlight[i].getPrice());
                        System.out.println(" From = "+routes[j].getSource()+"\t"+" To = "+routes[j].getDestination()+"\t"+" Distance = "+routes[j].getDistance()+
                                "\t"+" Time taken = "+routes[j].getTime()+"\t"+" Typical Airfare = "+ routes[j].getPrice());
                    }
                }
            }
        }
        return allFlight;
    }
}
