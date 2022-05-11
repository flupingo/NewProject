package Fundation.Enum;

public enum Enum002 {
    E("1", 2),
    E1("2", 3);


    String name;
    int age;

    Enum002(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int getAgeByName(String name) {
        for (Enum002 e : Enum002.values()) {
            if (e.name == name) {
                return e.getAge();
            }
        }
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println(Enum002.getAgeByName("2"));
        Enum002.E1.getAge();
    }
}
