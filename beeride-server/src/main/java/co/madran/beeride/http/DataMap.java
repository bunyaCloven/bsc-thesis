package co.madran.beeride.http;

import co.madran.beeride.model.Printable;

import java.util.HashMap;
import java.util.Map;

public class DataMap implements PrintMedium {

  private transient HashMap<String, Object> map;

  public DataMap() {
    this.map = new HashMap<String, Object>();
  }

  public Map<String, Object> with(Printable data) {
    data.print(this);
    return map;
  }

  @Override
  public void addProperty(String key, Object value) {
    map.put(key, value);
  }

}
