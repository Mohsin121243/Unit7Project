import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Calculate cost of one package");
        System.out.println("2. Simulate package");
        System.out.println("3. How packages cost are calculated");
        System.out.println("4. Exit");
        System.out.print("Input: ");
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        int opt = Integer.parseInt(ss);

        if(opt == 1){
            System.out.print("Enter the zip code of the origin package: ");
            int zip = s.nextInt();
            System.out.println("");
            System.out.print("Enter the zip code of the destination package: ");
            int zipDest = s.nextInt();
            System.out.println("");
            System.out.print("Enter the weight of the weight of the package: ");
            double weight = s.nextDouble();
            System.out.println("");
            System.out.print("Enter the height of the package: ");
            int height = s.nextInt();
            System.out.println("");
            System.out.print("Enter the length of the pacakge: ");
            int length = s.nextInt();
            System.out.println("");
            System.out.print("Enter the width of the package: ");
            int width = s.nextInt();

            Package p = new Package(Integer.toString(zip),Integer.toString(zipDest),weight,length,width,height);
            System.out.println(PostageCalculator.calculatePostage(p));
        }
        if(opt  == 2 ){
            System.out.print("How many package would you like to simulate: ");
            int pack = s.nextInt();
            PackageSimulator sim = new PackageSimulator();
            sim.generatePackages(pack);
            System.out.println(sim.getSimulationInfo());
            System.out.println(sim.generateTotalCost());


        }
        if(opt == 3){
            System.out.println("The base cost is $3.75\n" +
                    "Next: Add 5 cents for each tenth of a pound\n" +
                    "Next: Divide the difference in county codes by 100 and add that to calculate the final total\n" +
                    "The county code is the first 3 digits f the zip code\n" +
                    "Any package that exceeds a combined 36 inches will cost an additional 10 cents per inch.\n" +
                    "Additionally, packages that are more than 40 pounds will be charged 10 cents per tenth of a pound over the 40 pound limit.\n");

        }

    }
}
