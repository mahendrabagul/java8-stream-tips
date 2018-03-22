package info.mahendrabagul.runner.lambdas.bestpractice;

import java.util.function.Function;

public class UseFoo
{
    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
    public static void main(String[] args)
    {
        Function<String, String> fn = parameter -> parameter + " from lambda";
        String result = new UseFoo().add("Message ", fn);
        System.out.println(result);
    }
}

/*
@FunctionalInterface
interface Foo
{
    String method(String string);
}*/
