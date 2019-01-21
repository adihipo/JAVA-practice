import java.util.ArrayList;
import java.util.List;

public class Animals {

  private List<Animal> animals;

  public Animals() {
    animals = new ArrayList<>();
  }

  public List<Animal> getAnimals() {
    return this.animals;
  }

  public void setAnimals(List<Animal> animals) {
    this.animals = animals;
  }

}
