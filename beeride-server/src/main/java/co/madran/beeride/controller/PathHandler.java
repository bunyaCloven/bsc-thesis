package co.madran.beeride.controller;

import co.madran.beeride.http.ResponseEntityFactory;
import co.madran.beeride.model.dao.LocationRepository;
import co.madran.beeride.model.dao.PathRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paths")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class PathHandler {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PathRepository pathRepository;
  @Autowired
  private LocationRepository locationRepository;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> getPathsOfUser(@RequestParam String username) {
    final User user = userRepository.findByUsername(username);
    final List<Path> path = pathRepository.findByUser(user);
    return new ResponseEntityFactory(HttpStatus.OK).withAll(path);
  }

  @RequestMapping(path = "add", method = RequestMethod.POST)
  public ResponseEntity<Void> addPathToUser(@RequestParam String username,
      Path path) {
    User user = userRepository.findByUsername(username);
    path.setUser(user);
    /** FIXME: all this decoding is going to get messy to convert */
    // path.setStartLocation(locationRepository.save(Location.decode(start)));
    // path.setEndLocation(locationRepository.save(Location.decode(xend)));
    pathRepository.save(path);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "delete", method = RequestMethod.POST)
  public ResponseEntity<Void> deletePath(@RequestParam Long id) {
    final boolean existed = pathRepository.exists(id);
    pathRepository.delete(id);
    final boolean exists = pathRepository.exists(id);
    return new ResponseEntity<>(
        existed && !exists ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }

  @RequestMapping(path = "{id}")
  public ResponseEntity<Path> getPath(@PathVariable Long id) {
    return new ResponseEntity<>(pathRepository.findOne(id), HttpStatus.OK);
  }
}
