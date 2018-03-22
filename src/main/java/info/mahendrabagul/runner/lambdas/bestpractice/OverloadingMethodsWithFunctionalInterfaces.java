package info.mahendrabagul.runner.lambdas.bestpractice;

// Avoid Overloading Methods with Functional Interfaces as Parameters


import java.util.function.Consumer;
import java.util.function.Function;

public class OverloadingMethodsWithFunctionalInterfaces
{
    public static void main(String[] args)
    {
        AdderImpl adderImpl = new AdderImpl();
        // The first is to use methods with different names:
        System.out.println(adderImpl.addWithFunction(a -> a + " from lambda"));

        // The second is to perform casting manually. This is not preferred.
        System.out.println(adderImpl.add((Function) a -> a + " from lambda"));
    }
}

interface Adder
{
    String addWithFunction(Function<String, String> f);

    String add(Function<String, String> f);

    void addWithConsumer(Consumer<Integer> f);
}

class AdderImpl implements Adder
{
    @Override
    public String addWithFunction(Function<String, String> f)
    {
        return f.apply("Something ");
    }

    @Override
    public String add(Function<String, String> f)
    {
        return f.apply("Anything ");
    }

    @Override
    public void addWithConsumer(Consumer<Integer> f)
    {
    }
}