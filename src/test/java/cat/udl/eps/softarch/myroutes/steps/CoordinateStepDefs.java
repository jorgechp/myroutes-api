package cat.udl.eps.softarch.myroutes.steps;

import cat.udl.eps.softarch.myroutes.domain.Coordinate;
import cat.udl.eps.softarch.myroutes.domain.User;
import cat.udl.eps.softarch.myroutes.repository.CoordinateRepository;
import cat.udl.eps.softarch.myroutes.repository.UserRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CoordinateStepDefs {

  @Autowired
  private StepDefs stepDefs;

  @Autowired
  private CoordinateRepository coordinateRepository;

  @Given("^I register a new coordinate \"([^\"]*)\"$")
  public void iRegisterANewCoordinate(String coordinate) {
    Coordinate coordinateToBeCreated = new Coordinate();
    coordinateToBeCreated.setCoordinate(coordinate);
    coordinateRepository.save(coordinateToBeCreated);
  }


  @And("It has been created a coordinate {string}")
  public void itHasBeenCreatedACoordinate(String coordinate) {
    List<Coordinate> coordinates = coordinateRepository.findByCoordinate(coordinate);
    assertEquals(coordinates.size(), 1);
    assertEquals(coordinates.get(0).getCoordinate(), coordinate);
  }
}
