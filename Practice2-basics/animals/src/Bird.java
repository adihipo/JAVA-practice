public class Bird extends Animal {

  public Bird() {
    super();
  }

  public Bird(String name, int age) {
    super(name, age);
  }

  @Override
  public String makeSomeNoise() {
    return "chirp chirp";
  }
}
