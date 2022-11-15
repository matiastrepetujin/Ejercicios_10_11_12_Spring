package OB.Ejercicios10_11_12.Controllers;

import OB.Ejercicios10_11_12.Entities.Laptop;
import OB.Ejercicios10_11_12.Repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepositorio;

    public LaptopController(LaptopRepository laptopRepositorio) {
        this.laptopRepositorio = laptopRepositorio;
    }

    @GetMapping ("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepositorio.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepositorio.findById(id);

        if (laptopOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if(laptop.getId() != null){
            log.warn("Trata de crear una laptop con un id");
            return ResponseEntity.badRequest().build();
        }
        Laptop resultado = laptopRepositorio.save(laptop);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        if(laptop.getId() == null){
            log.warn("Trata de actualizar una laptop que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (laptopRepositorio.existsById(laptop.getId())){
            log.warn("La laptop que intenta actualizar no existe ");
            return ResponseEntity.notFound().build();
        }else{
            Laptop resultado = laptopRepositorio.save(laptop);
            return ResponseEntity.ok(resultado);
        }
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if (laptopRepositorio.existsById(id)) {
            log.warn("La laptop que intenta borrar no existe ");
            return ResponseEntity.notFound().build();
        }
        laptopRepositorio.deleteById(id);
        return ResponseEntity.noContent().build() ;
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> borrarTodo() {
        laptopRepositorio.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
