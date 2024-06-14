import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
    int totalPassengers;
    int totalPages;
    List<Data> data;

    public Response(@JsonProperty("totalPassengers") int totalPassengers,@JsonProperty("totalPages") int totalPages,
                    @JsonProperty("data")List<Data> data) {
        this.totalPassengers = totalPassengers;
        this.totalPages = totalPages;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "totalPassengers=" + totalPassengers +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}

class Data{

    List<Person> people;

    public Data( List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Data{" +
                "people=" + people +
                '}';
    }
}

class Person{
    String id;
    String name;
    String trips;
    List<AirLine> airlines;

    public Person(@JsonProperty("_id")String id,@JsonProperty("name") String name,@JsonProperty("trips") String trips,
                @JsonProperty("airline") List<AirLine> airlines) {
        this.id = id;
        this.name = name;
        this.trips = trips;
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", trips='" + trips + '\'' +
                ", airlines=" + airlines +
                '}';
    }
}

class AirLine{
    int id;
    String name;
    String country;
    String logo;
    String slogan;
    String headQuaters;
    String website;
    String establishedYear;

    public AirLine(@JsonProperty("id")int id,@JsonProperty("name") String name,@JsonProperty("country") String country,
                   @JsonProperty("logo")String logo,@JsonProperty("slogan") String slogan,
                   @JsonProperty("head_quaters") String headQuaters,@JsonProperty("website") String website,
                   @JsonProperty("established")String establishedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.logo = logo;
        this.slogan = slogan;
        this.headQuaters = headQuaters;
        this.website = website;
        this.establishedYear = establishedYear;
    }

    @Override
    public String toString() {
        return "AirLine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", logo='" + logo + '\'' +
                ", slogan='" + slogan + '\'' +
                ", headQuaters='" + headQuaters + '\'' +
                ", website='" + website + '\'' +
                ", establishedYear='" + establishedYear + '\'' +
                '}';
    }
}
