public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int n , int d) {
        numerator = n;
        denominator = d;
    }

    public Fraction(String fraction) {
        /*
            * I'm writing this one for you guys. Example you pass 8/3 to this constructor,
            * the first statement will split the string into two strings and save it as a string array
            * then the next two statements will store into numerator and denominator after parsing the String to integer
        */
        String[] numbers = fraction.split("/");
        this.numerator = Integer.parseInt(numbers[0]);
        this.denominator = Integer.parseInt(numbers[1]);
    }

    public int getNumerator() {
        /* Write this function. It should return the value of the numerator */
        return numerator;
    }

    public int getDenominator() {
        /* Write this function. It should return the value of the denominator */
        return denominator;
    }

    public void setNumerator(int n) {
       // Write this function. It should set the value of the numerator 
        numerator = n;
        

    }

    public void setDenominator(int d) {
        // Write this function. It should set the value of the denominator 
        denominator = d;

    }

    public float getValue() {
        /* Write this function. It should divide the numerator with denominator and return the result */
        float ans = (float)getNumerator()/getDenominator();
        return ans;
    }
}