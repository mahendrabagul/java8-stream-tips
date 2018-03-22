package info.mahendrabagul.runner.lambdas.avoid;

// Avoid Overloading Methods with Functional Interfaces as Parameters


import java.util.function.Consumer;
import java.util.function.Function;

public class OverloadingMethodsWithFunctionalInterfaces
{
    public static void main(String[] args)
    {
        AdderImpl adderImpl = new AdderImpl();
        // The second is to perform casting manually. This is not preferred.
        System.out.println(adderImpl.add(a -> a + " from lambda"));
    }
}

interface Adder
{
    String add(Function<String, String> f);

    void add(Consumer<Integer> f);
}

class AdderImpl implements Adder
{
    @Override
    public String add(Function<String, String> f)
    {
        return f.apply("Something ");
    }

    @Override
    public void add(Consumer<Integer> f)
    {
        f.accept(10);
    }
}