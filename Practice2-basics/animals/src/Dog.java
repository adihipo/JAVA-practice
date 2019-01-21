class Dog extends Animal{

  Dog() {
    super();
  }

  Dog(String name, int age) {
    super(name, age);
  }

  @Override
  String makeSomeNoise() {
    return "vau vau vau";
  }
}
