public class Bird extends Animal implements Flyable{

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

  @Override
  public String fly() {
    return "flaps proudly";
  }
}
