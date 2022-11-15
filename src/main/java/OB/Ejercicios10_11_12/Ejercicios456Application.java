package OB.Ejercicios10_11_12;

import OB.Ejercicios10_11_12.Entities.Laptop;
import OB.Ejercicios10_11_12.Repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios456Application {

	public static void main(String[] args) {
		ApplicationContext contexto = SpringApplication.run(Ejercicios456Application.class, args);

		LaptopRepository repositorio = contexto.getBean(LaptopRepository.class);

		Laptop ejemplo1 = new Laptop(null, "HP", true, 8, "Intel Core i3", 256, 15.6);
		Laptop ejemplo2 = new Laptop(null, "Dell", true, 8, "AMD Ryzen 5", 256, 15.5);

		System.out.println("La cantidad de laptops en la base de datos es: " + repositorio.count());

		repositorio.save(ejemplo1);
		repositorio.save(ejemplo2);

		System.out.println("La cantidad de laptops en la base de datos es: " + repositorio.count());


	}



}
