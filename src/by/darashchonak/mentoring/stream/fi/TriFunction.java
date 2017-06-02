package by.darashchonak.mentoring.stream.fi;

/**
 * Created by Mikhail_Darashchonak on 6/2/17.
 */

@FunctionalInterface
public interface TriFunction<T, U, S, R> {

    R apply(T t, U u, S s);
}
