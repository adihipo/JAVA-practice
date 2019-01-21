class Bird extends Animal implements Flyable{

  Bird() {
    super();
  }

  Bird(String name, int age) {
    super(name, age);
  }

  @Override
  String makeSomeNoise() {
    return "chirp chirp";
  }

  @Override
  public String fly() {
    return "flaps proudly";
  }
}
