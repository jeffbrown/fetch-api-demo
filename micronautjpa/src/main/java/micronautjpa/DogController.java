package micronautjpa;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/dog")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Post("/")
    public Dog create(String breed,
                      String name) {
        return dogService.save(breed, name);
    }

    @Put("/{id}")
    public Dog update(Long id,
               String breed,
               String name) {
        return dogService.update(id, breed, name);
    }

    @Get("/")
    public List<Dog> list() {
        return dogService.list();
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id) {
        dogService.delete(id);
        return HttpResponse.ok();
    }
}
