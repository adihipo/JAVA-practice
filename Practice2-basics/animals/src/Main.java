import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Animals animals = createAnimals();
    makeNoiseAnimals(animals);
    flyWhoCan(animals);
  }

  static Animals createAnimals() {
    Animals animals = new Animals();
    List<Animal> animalList= new ArrayList<>();
    Animal monkey = new Monkey("Monkeee", 7);
    Animal bird = new Bird("Birdie", 18);
    Animal dog = new Dog("Doggie", 2);
    animalList.add(monkey);
    animalList.add(bird);
    animalList.add(dog);
    animals.setAnimals(animalList);
    return animals;
  }

  static void makeNoiseAnimals(Animals animals) {
    for (Animal animal : animals.getAnimals()) {
      System.out.println(animal.makeSomeNoise());
    }
  }

  static void flyWhoCan(Animals animals) {
    for (Animal animal : animals.getAnimals()) {
      if(animal instanceof Flyable) {
        System.out.println(((Flyable) animal).fly());
      }
    }
  }

}
