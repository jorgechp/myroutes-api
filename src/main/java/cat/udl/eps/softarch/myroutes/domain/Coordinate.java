package cat.udl.eps.softarch.myroutes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Coordinate extends UriEntity<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    private String coordinate;

}
