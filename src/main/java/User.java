import java.util.Objects;

public class User {

    private int id;
    private String name;
    private int age;
    private boolean isWorker;

    public User(int id, String name, int age, boolean isWorker) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isWorker = isWorker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && isWorker == user.isWorker && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, isWorker);
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", name = " + name +
                ", age = " + age +
                ", isWorker = " + isWorker;
    }
}
