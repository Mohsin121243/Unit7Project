import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class PackageSimulator {
    private ArrayList<Package> packages;


    public PackageSimulator() {
        this.packages = new ArrayList<Package>();
    }


    public void generatePackages(int numPackages) {
        ArrayList<String> zips = new ArrayList<String>();
        ArrayList<String> city = new ArrayList<String>();
        ArrayList<String> state = new ArrayList<String>();
        try
        {
            FileReader fileReader = new FileReader("src/zip_code_database.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] movieFromCSV = line.split(",");
                boolean zippy = true;

                String zipcode = movieFromCSV[0];
                String cityName = movieFromCSV[3];
                String stateName = movieFromCSV[6];
                if(Integer.parseInt(zipcode.substring(0,1))>0) {
                    zips.add(zipcode);
                    city.add(cityName);
                    state.add(stateName);
                }
            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {

            System.out.println("Unable to access " + exception.getMessage());
        }
        for (int i = 0; i < numPackages; i++) {
            int randomNumber = (int) (Math.random() * 1001);
            int a= (int)(Math.random()*(zips.size()+1));
            Address fromAddr = new Address(Integer.toString(randomNumber),"A",Integer.toString(1), Integer.parseInt(zips.get(a)), city.get(a),state.get(a));
            int b = (int)(Math.random()*(zips.size()+1));
            int randomNum = (int) (Math.random() * 1001);
            Address toAddr =  new Address(Integer.toString(randomNum),"A",Integer.toString(2), Integer.parseInt(zips.get(b)), city.get(b),state.get(b));;

            // generate a random weight between 0.5 and 10.0 pounds
            double weight = 0.5 + (Math.random() * 9.5);

            // generate a random package size between 6 and 24 inches for each dimension
            int length =  (int) (Math.random() * 19) + 6;
            int width =  (int) (Math.random() * 19) + 6;
            int height =  (int) (Math.random() * 19) + 6;

            // create the package and add it to the ArrayList
            String from = fromAddr.getNumOfStreet() + " "+ fromAddr.getNameOfStreet() +" " + fromAddr.getApartmentNum() + ", "+fromAddr.getCity() + ", "+fromAddr.getState()+", "+fromAddr.getZipcode();
            String to = toAddr.getNumOfStreet() + " "+ toAddr.getNameOfStreet() +" " + toAddr.getApartmentNum() + ", "+toAddr.getCity() + ", "+toAddr.getState()+", "+toAddr.getZipcode();
            Package p = new Package(from,to,weight, length, width, height);
            this.packages.add(p);
        }
    }





    /**
     * Calculate the total cost of all packages in the ArrayList
     * @return the total cost of all packages
     */
    public double generateTotalCost() {
        double totalCost = 0.0;
        for (Package p : this.packages) {
            totalCost += PostageCalculator.calculatePostage(p);
        }
        return totalCost;
    }

    /**
     * Get the simulation info in the format specified in the prompt
     * @return the simulation info as a string
     */
    public String getSimulationInfo() {
        String info = "";
        for (Package p : this.packages) {
            info += "From: " + p.getOrigin().toString() + "\n";
            info += "To: " + p.getDest().toString() + "\n";
            info += "Weight: " + p.getWeight() + " lbs\n";
            info += "Length: " + p.getLength()  + " inches\n";
            info += "Height: "  + p.getHeight() + " inches\n";
            info += "Width: " + p.getWidth() + "inches\n";
            info += "Cost: $" + String.format("%.2f", PostageCalculator.calculatePostage(p)) + "\n\n";
        }
        return info;
    }

    /**
     * Reset the ArrayList of packages to empty
     */
    public void resetSimulation() {
        this.packages.clear();
    }
}