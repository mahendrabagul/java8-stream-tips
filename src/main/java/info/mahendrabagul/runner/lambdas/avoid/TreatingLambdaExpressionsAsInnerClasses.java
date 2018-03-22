package info.mahendrabagul.runner.lambdas.avoid;


public class TreatingLambdaExpressionsAsInnerClasses
{
    private String value = "Enclosing scope value";

    public static void main(String[] args)
    {
        System.out.println(new TreatingLambdaExpressionsAsInnerClasses().scopeExperiment());
    }

    public String scopeExperiment()
    {
        MyFoo fooIC = new MyFoo()
        {
            String value = "Inner class value";

            @Override
            public String method(String string)
            {
                //Accessing outer this
                //System.out.println(TreatingLambdaExpressionsAsInnerClasses.this.value);
                return this.value;
            }
        };
        String resultIC = fooIC.method("");

        MyFoo fooLambda = parameter ->
        {
            String value = "Lambda value";
            return this.value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }
}

@FunctionalInterface
interface MyFoo
{
    String method(String string);
}