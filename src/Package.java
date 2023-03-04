public class Package {
    private String origin;
    private String dest;

    private double weight;
    private double length;
    private double width;
    private double height;


    public Package(String org,String dest,double weight, double l , double w, double h){
      if(weight>=0.1){
          this.weight = weight;
      }
      if(l>=2 && w>=2 && h>=2){
          length = 1;
          width = w;
          height = h;
      }
      origin = org;
      this.dest = dest;
    }


    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }




}
