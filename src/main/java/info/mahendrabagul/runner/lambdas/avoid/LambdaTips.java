package info.mahendrabagul.runner.lambdas.avoid;


public class LambdaTips
{
    public static void main(String[] args)
    {
        //  Avoid Blocks of Code in Lambda’s Body
        /*MyFoo1 foo1 = parameter ->
        {
            String result = "Something " + parameter;
            //many lines of code
            return result;
        };*/

        // However, please don’t use this “one-line lambda” rule as dogma.
        // If you have two or three lines in lambda’s definition,
        // it may not be valuable to extract that code into another method.

        MyFoo1 foo2 = parameter -> buildString(parameter);

        // Avoid Specifying Parameter Types
        // MyFoo2 myFoo2 = (String a, String b) -> a.toLowerCase() + b.toLowerCase();
        MyFoo2 myFoo1 = (a, b) -> a.toLowerCase() + b.toLowerCase();

        // Avoid Parentheses Around a Single Parameter
        // MyFoo1 myFoo11 = (a) -> a.toLowerCase();
        MyFoo1 myFoo12 = a -> a.toLowerCase();

        // Avoid Return Statement and Braces
        /* MyFoo1 myFoo111 = a ->
        {
            return a.toLowerCase();
        };*/
        MyFoo1 myFoo112 = a -> a.toLowerCase();

        // Use Method References
        // MyFoo1 myFoo1111 = a -> a.toLowerCase();
        MyFoo1 myFoo1112 = String::toLowerCase;

        // Use “Effectively Final” Variables
        String localVariable = "Local";
        Foo foo = parameter ->
        {
            // String localVariable = parameter;
            return localVariable;
        };

        // Protect Object Variables from Mutation
        int[] total = new int[1];
        Runnable r = () -> total[0]++;
        r.run();
    }

    private static String buildString(String parameter)
    {
        String result = "Something " + parameter;
        //many lines of code
        return result;
    }
}

@FunctionalInterface
interface MyFoo1
{
    String method(String string);
}

@FunctionalInterface
interface MyFoo2
{
    String method(String string1, String string2);
}