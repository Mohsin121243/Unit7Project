public class Package {
    private String origin;
    private String dest;

    private double weight;
    private double length;
    private double width;
    private double height;

    public Package(double weight,double l , double w, double h,){
      if(weight>=0.1){
          this.weight = weight;
      }
      if(l>=2 && w>=2 &&
    }

    public void Addy(String origin){
        this.origin = origin;
    }

    public void AddyDest(String dest){
        this.dest = dest;
    }





}
