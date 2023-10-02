package cat.udl.eps.softarch.myroutes.steps;

import cat.udl.eps.softarch.myroutes.domain.Coordinate;
import cat.udl.eps.softarch.myroutes.repository.CoordinateRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class CoordinateStepDefs {

  @Autowired
  private StepDefs stepDefs;

  @Autowired
  private CoordinateRepository coordinateRepository;


  @When("I register a new coordinate {string}")
  public void iRegisterANewCoordinate(String coordinate) throws Throwable{
    Coordinate c = new Coordinate();
    c.setCoordinate(coordinate);

    stepDefs.result = stepDefs.mockMvc.perform(
                    post("/coordinates")
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .characterEncoding("utf-8")
                            .content(stepDefs.mapper.writeValueAsString(c))
                            .accept(MediaType.APPLICATION_JSON)
                            .with(AuthenticationStepDefs.authenticate()))
            .andDo(print());

  }

  @And("It has been created a coordinate {string}")
  public void itHasBeenCreatedACoordinate(String coordinate) {
    List<Coordinate> cs = this.coordinateRepository.findByCoordinate(coordinate);
    assertEquals(cs.size(), 1);
    assertEquals(cs.get(0).getCoordinate(), coordinate);
  }
}
