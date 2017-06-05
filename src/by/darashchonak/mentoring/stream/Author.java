package by.darashchonak.mentoring.stream;

public class Author {

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 42;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
