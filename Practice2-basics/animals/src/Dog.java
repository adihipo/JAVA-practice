public class Dog extends Animal{

  public Dog() {
    super();
  }

  public Dog(String name, int age) {
    super(name, age);
  }

  @Override
  public String makeSomeNoise() {
    return "vau vau vau";
  }
}
