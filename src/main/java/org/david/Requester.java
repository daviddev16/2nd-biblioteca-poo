package org.david;

import org.david.exceptions.EvaluationException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public final class Requester {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Class<?>, Function<Scanner, Object>> dataTypes = new HashMap<>();

    static {
        handle(String.class, Scanner::nextLine);
        handle(Integer.class, Scanner::nextInt);
        handle(Float.class, Scanner::nextFloat);
        handle(Double.class, Scanner::nextDouble);
        handle(Long.class, Scanner::nextLong);
        handle(Byte.class, Scanner::nextByte);
        handle(Short.class, Scanner::nextShort);
        handle(Boolean.class, Scanner::nextBoolean);
        handle(Heavy.class, Heavy::new);
    }

    private Requester(String title) {
        if (title == null || title.isBlank())
            throw new NullPointerException("Título não pode ser nulo ou vazio.");

        System.out.println(title);
    }

    public Object readValue(Class<?> requestType) {
        if (requestType == null)
            throw new EvaluationException("O tipo da requisição não pode ser nulo.");

        else if (!hasType(requestType))
            throw new EvaluationException(requestType, dataTypes.keySet());

        return evaluate(requestType);
    }

    private Object tryEvaluate(Class<?> requestType) {
        try {
            return dataTypes.get(requestType).apply(scanner);
        } catch (InputMismatchException e) {
            throw new EvaluationException("Tipo inválido / Tente novamente: ");
        } catch (Exception e) {
            throw new EvaluationException("Erro ao tentar receber dado. [" + e.getMessage() + "]");
        }
    }

    private Object evaluate(Class<?> requestType) {
        Object value;
        try {
            value = tryEvaluate(requestType);
            skip(requestType);
        } catch (EvaluationException e) {
            skip(requestType);
            System.out.println(e.getMessage());
            return evaluate(requestType);
        }
        return value;
    }

    public void skip(Class<?> dateType) {
        if (!dateType.isAssignableFrom(String.class)) {
            scanner.nextLine();
        }
    }

    public boolean hasType(Class<?> requestType) {
        return dataTypes.containsKey(requestType);
    }

    public static void handle(Class<?> dataType, Function<Scanner, Object> function) {
        dataTypes.putIfAbsent(dataType, function);
    }

    @SuppressWarnings({"uncheked", "unsafe"})
    public static <E> E request(Class<E> requestType, String title) {
        return (E) new Requester(title).readValue(requestType);
    }

    public static void freeze() {
        System.out.println("\n[Pressione ENTER]");
        scanner.nextLine();
    }

}
