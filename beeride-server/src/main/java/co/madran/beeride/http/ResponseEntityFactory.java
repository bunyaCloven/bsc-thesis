package co.madran.beeride.http;

import co.madran.beeride.model.Printable;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory implements PrintMedium {
  private transient HttpStatus status;
  private transient HashMap<String, Object> map;

  public ResponseEntityFactory(final HttpStatus status) {
    this.status = status;
    this.map = new HashMap<String, Object>();
  }

  public ResponseEntity<Void> emptyBody() {
    return new ResponseEntity<>(status);
  }

  public ResponseEntity<HashMap<String, Object>> with(Printable data) {
    data.print(this);
    return new ResponseEntity<>(map, status);
  }

  @Override
  public void addProperty(String key, Object value) {
    map.put(key, value);
  }

}
