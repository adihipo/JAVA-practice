import java.util.ArrayList;
import java.util.List;

class Garden {

  private List<Animal> garden;

  Garden() {
    this.garden = new ArrayList<>();
  }

  void createAnimals() {
    Animal monkey = new Monkey("Monkeee", 7);
    Animal bird = new Bird("Birdie", 18);
    Animal dog = new Dog("Doggie", 2);
    this.garden.add(monkey);
    this.garden.add(bird);
    this.garden.add(dog);
  }

  void makeNoiseAnimals() {
    for (Animal animal : this.garden) {
      System.out.println(animal.makeSomeNoise());
    }
  }

  void flyWhoCan() {
    for (Animal animal : this.garden) {
      if(animal instanceof Flyable) {
        System.out.println(((Flyable) animal).fly());
      }
    }
  }

}
