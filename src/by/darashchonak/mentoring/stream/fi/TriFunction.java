package by.darashchonak.mentoring.stream.fi;

@FunctionalInterface
public interface TriFunction<T, U, S, R> {

    R apply(T t, U u, S s);
}
