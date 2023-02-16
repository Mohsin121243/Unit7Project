public class Package {
    private String origin;
    private String dest;

    private double weight;
    private double length;
    private double width;
    private double height;


    public Package(double weight, double l , double w, double h){
      if(weight>=0.1){
          this.weight = weight;
      }
      if(l>=2 && w>=2 && h>=2){
          length = 1;
          width = w;
          height = h;
      }
    }

    public void Addy(String origin){
        this.origin = origin;
    }

    public void AddyDest(String dest){
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
