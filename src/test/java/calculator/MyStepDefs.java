package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepDefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private char operation;
    private int result;
    private boolean isDivideByZeroThrown;
    private boolean isIllegalArgumentThrown;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+), and an operation ([/^])$")
    public void twoInputValuesAndAnOperation(int arg0, int arg1, char arg2) {
        isDivideByZeroThrown = false;
        value1 = arg0;
        value2 = arg1;
        operation = arg2;
    }

    @When("^I perform the operation$")
    public void iPerformTheOperation() {
        if (operation == '/') {
            try {
                result = calculator.divide(value1, value2);
            } catch (ArithmeticException e) {
                isDivideByZeroThrown = true;
            }
        } else {
            try {
                result = calculator.power(value1, value2);
            } catch (IllegalArgumentException e) {
                isIllegalArgumentThrown = true;
            }
        }
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @Then("^I expect the divide by zero exception$")
    public void iExpectTheDivideByZeroException() {
        Assert.assertTrue(isDivideByZeroThrown);
    }

    @Then("^I expect the illegal argument exception$")
    public void iExpectTheIllegalArgumentException() {
        Assert.assertTrue(isIllegalArgumentThrown);
    }
}