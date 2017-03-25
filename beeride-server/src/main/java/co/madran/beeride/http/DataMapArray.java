package co.madran.beeride.http;

import co.madran.beeride.model.Printable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataMapArray {
  public List<Map<String, Object>> with(Iterable<? extends Printable> data) {
    List<Map<String, Object>> result = new LinkedList<>();
    for (Printable value : data) {
      result.add(new DataMap().with(value));
    }
    return result;
  }
}
