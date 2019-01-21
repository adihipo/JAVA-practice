class Monkey extends Animal{

  Monkey() {
    super();
  }

  Monkey(String name, int age) {
    super(name, age);
  }

  @Override
  String makeSomeNoise() {
    return "u u u";
  }
}
