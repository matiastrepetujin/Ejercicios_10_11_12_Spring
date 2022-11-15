package OB.Ejercicios10_11_12.Repositories;

import OB.Ejercicios10_11_12.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
