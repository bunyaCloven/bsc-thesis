// package co.madran.beeride.integration.controller;
//
// import static org.hamcrest.CoreMatchers.not;
// import static org.hamcrest.CoreMatchers.nullValue;
// import static org.junit.Assert.assertThat;
//
// import co.madran.beeride.Starter;
// import co.madran.beeride.controller.CarHandler;
// import co.madran.beeride.integration.config.TestDatabaseConfig;
// import co.madran.beeride.model.dao.UserRepository;
// import co.madran.beeride.model.domain.User;
// import co.madran.beeride.security.SecurityRequestHandler;
// import co.madran.beeride.security.UserService;
//
// import java.util.UUID;
//
// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.test.annotation.Rollback;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;
//
// @RunWith(SpringRunner.class)
// @ContextConfiguration(classes = { TestDatabaseConfig.class })
// @EnableJpaRepositories(basePackageClasses = UserRepository.class)
// @ComponentScan(basePackageClasses = { User.class })
//// @TestPropertySource(locations = "classpath:test.properties")
// @SpringBootTest(classes = Starter.class)
// @Transactional(transactionManager = "transactionManager", propagation =
// Propagation.REQUIRES_NEW)
// @Rollback(false)
// @WebAppConfiguration
// @DataJpaTest
// public class CarHandlerTest {
// @Autowired
// private CarHandler handler;
//
// @Autowired
// private SecurityRequestHandler userHandler;
//
// @Autowired
// private UserService userService;
// @PersistenceContext
// private EntityManager entityManager;
//
// @Before
// public void setup() {
// assertThat(handler, not(nullValue()));
// assertThat(userHandler, not(nullValue()));
// }
//
// @Test
// public void testGetNewCarOfNewUserThenDelete() {
// final String username = "user0";
// final String email = "can@madran.co";
// final String password = UUID.randomUUID().toString();
// // FIXME:the tests are not working
// // FIXME: two usernames come from UI
// // final String signupResult = userHandler.signup(',' + username, email,
// // password, password);
// // final UserDetails user = userService.loadUserByUsername(username);
// // assertThat(user, is(not(null)));
// // final String carName = "carname";
// // final String carbrand = "carbrand";
// // final Integer passengerCount = 5;
// // final String plate = "arbirtraryplate";
// // final String carAddResult = handler.addCarToUser(null, username, carName,
// // carbrand, passengerCount, plate);
// // // FIXME: make a proper object
// // final Map<String, Object> result = new Gson()
// // .fromJson(handler.getCarsOfUser(username), Map.class);
// // assertThat(result.get("success"), is(true));
// // Car car = ((List<Car>) result.get("data")).get(0);
// //
// // assertThat(car.getName(), equalTo(carName));
// // assertThat(car.getBrand(), is(carbrand));
// // assertThat(car.getPassengerCount(), is(passengerCount));
// // assertThat(car.getPlate(), is(plate));
// }
// }
