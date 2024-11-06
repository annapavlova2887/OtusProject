package exceptions;

public class BrowserNotFoundExpectation extends RuntimeException{
    public BrowserNotFoundExpectation(String browserName) {
        super(String.format("Browser %s not supported", browserName));
    }
}
