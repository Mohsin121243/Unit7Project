import java.util.ArrayList;
public class Address {
    private String numOfStreet;
    private String nameOfStreet;
    private String apartmentNum;
    private String city;
    private String state;
    private int zipcode;

    public Address(String numOfStreet, String nameOfStreet,String apartmentNum, int zipcode,String state,String city){
        this.numOfStreet = numOfStreet;
        this.nameOfStreet = nameOfStreet;
        this.apartmentNum = apartmentNum;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public Address(Address ad){
        this.numOfStreet = ad.getNumOfStreet();
        this.nameOfStreet = ad.getNameOfStreet();
        this.apartmentNum = ad.getApartmentNum();
        this.city = ad.getCity();
        this.state = ad.getState();
        this.zipcode= ad.getZipcode();
    }

    public Address(String adAsString){
        String[] addy = adAsString.split(",");
        nameOfStreet = addy[0];
        for(int i = 0; i<=6;i++){

        }
    }
    public String getNumOfStreet() {
        return numOfStreet;
    }

    public String getNameOfStreet() {
        return nameOfStreet;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getAddressLine() {return numOfStreet + ", "+ nameOfStreet + ", "+apartmentNum+", "+city+", "+state+", "+zipcode;}


}
