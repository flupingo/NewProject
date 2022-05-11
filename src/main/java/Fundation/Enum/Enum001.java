package Fundation.Enum;

public enum Enum001 {
    Little("liu", "5"),
    Middle("zhang", "12");

    private String name;
    private String age;

    Enum001(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public static String getAgeByName(String name) {
        for (Enum001 enum001 : Enum001.values()) {
            if (enum001.name == name) {
                return enum001.age;
            }
        }
        return null;
    }
}
