public class PostageCalculator {
    private double cost;
    public PostageCalculator(Package pack, Address addy){
        int addres = Integer.parseInt(Integer.toString(addy.getZipcode()).substring(0,3))-100;
        cost = 3.75 + pack.getWeight()/0.1 + addres;
        if(pack.getLength() + pack.getHeight() + pack.getWidth() > 36){
            cost = cost + ((36-(pack.getLength() + pack.getHeight() + pack.getWidth()))*0.10);
        }
        if(pack.getWeight()>40){
            cost = cost + (40-())
        }
    }
}
