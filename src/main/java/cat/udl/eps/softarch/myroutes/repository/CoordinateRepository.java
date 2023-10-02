package cat.udl.eps.softarch.myroutes.repository;

import cat.udl.eps.softarch.myroutes.domain.Coordinate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoordinateRepository extends CrudRepository<Coordinate, Long>, PagingAndSortingRepository<Coordinate, Long> {

    List<Coordinate> findByIdContaining(@Param("text") String text);
    List<Coordinate> findByCoordinate(@Param("text") String text);
}
