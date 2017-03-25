package co.madran.beeride.http;

import co.madran.beeride.model.Printable;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory {
  private transient HttpStatus status;

  public ResponseEntityFactory(final HttpStatus status) {
    this.status = status;
  }

  public ResponseEntity<Void> emptyBody() {
    return new ResponseEntity<>(status);
  }

  public ResponseEntity<Map<String, Object>> with(Printable data) {
    return new ResponseEntity<>(new DataMap().with(data), status);
  }

  public ResponseEntity<List<Map<String, Object>>> withAll(
      List<? extends Printable> data) {
    return new ResponseEntity<>(new DataMapArray().with(data), status);
  }

}
