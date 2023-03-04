public class PostageCalculator {
    private static final double baseCost = 3.75;
    private static final double perTenthPound = 0.05;
    private static final double perHunnid = 0.01;
    private static final double perInch= 0.10;
    private static final double overweightCost = 0.10;
    private static final int sizeLimit = 36;
    private static final int weightLimit = 40;


    public double calculatePostage(String fromZip, String toZip, double weight, int length, int width, int height) {
        double cost = baseCost + ((weight / 0.10) * perTenthPound);
        int fromCountyCode = Integer.parseInt(fromZip.substring(0, 3));
        int toCountyCode = Integer.parseInt(toZip.substring(0, 3));
        cost += Math.abs(toCountyCode - fromCountyCode) / 100.0 ;
        int combinedSize = length + width + height;
        if (combinedSize > sizeLimit) {
            cost += ((combinedSize - sizeLimit) * perInch);
        }
        if (weight > weightLimit) {
            cost += (((weight - weightLimit)/0.10)*0.10) ;
        }
        return cost;
    }


    public  double calculatePostage(Address fromAddr, Address toAddr, double weight, int length, int width, int height) {
        double cost = baseCost + ((weight / 0.10) * perTenthPound);
        int fromCountyCode = Integer.parseInt(Integer.toString(fromAddr.getZipcode()).substring(0, 3));
        int toCountyCode = Integer.parseInt(Integer.toString(toAddr.getZipcode()).substring(0, 3));
        cost += Math.abs(toCountyCode - fromCountyCode) / 100.0 ;
        int combinedSize = length + width + height;
        if (combinedSize > sizeLimit) {
            cost += ((combinedSize - sizeLimit) * perInch);
        }
        if (weight > weightLimit) {
            cost += (((weight - weightLimit)/0.10)*0.10) ;
        }
        return cost;
    }


    public static double calculatePostage(Package p) {
        double cost = baseCost + ((p.getWeight() / 0.10) * perTenthPound);
        int fromCountyCode = Integer.parseInt(p.getOrigin().substring(0, 3));
        int toCountyCode = Integer.parseInt(p.getDest().substring(0, 3));
        cost += Math.abs(toCountyCode - fromCountyCode) / 100.0 ;
        double combinedSize = p.getLength() + p.getWidth() + p.getHeight();
        if (combinedSize > sizeLimit) {
            cost += ((combinedSize - sizeLimit) * perInch);
        }
        if (p.getWidth() > weightLimit) {
            cost += ((p.getWeight() - weightLimit)/0.10) * 0.10;
        }
        return cost;
    }
}