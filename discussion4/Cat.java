public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
        this.noise = "mgd";
        super.noise = "Meow!";

    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String[] args) {
        Cat cat0 = new Cat("MM", 12);
        cat0.greet();
    }

}
