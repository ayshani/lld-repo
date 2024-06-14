import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class User {


    int id;
    String name;
    String username;
    @JsonProperty("email")
    String emailId;
    @JsonProperty("address")
    Address address;
    String phone;
    String website;
    Company company;

    public User(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("username") String username,
                @JsonProperty("email") String emailId,@JsonProperty("address") Address address,
                @JsonProperty("phone") String phone,@JsonProperty("website") String website,
                @JsonProperty("company") Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.emailId = emailId;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}


class Address{
    String street;
    String suite;
    String city;
    @JsonProperty("zipcode")
    String zipCode;
    Geo geo;

    public Address(@JsonProperty("street") String street,@JsonProperty("suite") String suite,
                   @JsonProperty("city") String city,@JsonProperty("zipcode") String zipCode,
                   @JsonProperty("geo") Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", geo=" + geo +
                '}';
    }
}

class Geo{
    String lat;
    String lng;

    public Geo(@JsonProperty("lat") String lat,@JsonProperty("lng") String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}

class Company{
    String name;
    String catchPhrase;
    String bs;

    public Company(@JsonProperty("name") String name,@JsonProperty("catchPhrase") String catchPhrase,
                   @JsonProperty("bs") String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
