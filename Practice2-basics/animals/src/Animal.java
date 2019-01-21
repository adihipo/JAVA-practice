abstract class Animal {

  private String name;
  private int age;

  Animal() {
  }

  Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  int getAge() {
    return this.age;
  }

  void setAge(int age) {
    this.age = age;
  }

  abstract String makeSomeNoise();
}
