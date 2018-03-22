package info.mahendrabagul.runner.lambdas.avoid;

//Prefer Standard Functional Interfaces
public class UseFoo
{
    public String add(String string, Foo foo)
    {
        return foo.method(string);
    }

    public static void main(String[] args)
    {
        Foo foo = parameter -> parameter + " from lambda";
        String result = new UseFoo().add("Message ", foo);
        System.out.println(result);
    }
}

//Show the impact of not using @FunctionalInterface
@FunctionalInterface
interface Foo
{
    String method(String string);
}