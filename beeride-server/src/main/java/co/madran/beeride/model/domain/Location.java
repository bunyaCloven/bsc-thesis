package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
  private @Id @GeneratedValue Long id;
  private Double latitude;
  private Double longitude;

  public Location() {
  }

  public Location(Double lat, Double lng) {
    latitude = lat;
    longitude = lng;
  }

  public static Location decode(String encoded) {
    String[] decoded = encoded.split(",");
    return new Location(Double.valueOf(decoded[0]), Double.valueOf(decoded[1]));
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }
}
