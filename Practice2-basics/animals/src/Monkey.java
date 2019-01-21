public class Monkey extends Animal{

  public Monkey() {
    super();
  }

  public Monkey(String name, int age) {
    super(name, age);
  }

  @Override
  public String makeSomeNoise() {
    return "u u u";
  }
}
