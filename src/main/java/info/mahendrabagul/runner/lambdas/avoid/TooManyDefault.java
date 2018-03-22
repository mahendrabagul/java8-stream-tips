package info.mahendrabagul.runner.lambdas.avoid;

// Don’t Overuse Default Methods in Functional Interfaces
public class TooManyDefault implements FooExtended
{
    public static void main(String[] args)
    {
        System.out.println(new TooManyDefault().method());
    }

    @Override
    public String method()
    {
        FooExtended.super.defaultBaz();
        return "Method called";
    }
}

@FunctionalInterface
interface FooExtended extends Baz, Bar
{
    default void defaultBaz()
    {
        Baz.super.defaultBaz();
    }
}

@FunctionalInterface
interface Baz
{
    String method();

    default void defaultBaz()
    {
        System.out.println("In the DefaultBaz");
    }
}

@FunctionalInterface
interface Bar
{
    String method();

    default void defaultBar()
    {
        System.out.println("In the DefaultBar");
    }
}