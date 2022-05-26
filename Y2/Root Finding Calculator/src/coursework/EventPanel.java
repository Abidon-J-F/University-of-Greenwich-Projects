package coursework;

import java.util.EventObject;

/**
 *
 * @author Abidon Jude Fernandes
 */
//Getters and Setters for the four root finding methods
public class EventPanel extends EventObject {

    private String min;
    private String max;
    private String Bisection1;
    private String Bisection2;
    private String Bisection3;
    private String NR1;
    private String NR2;
    private String NR3;
    private String Secant1;
    private String Secant2;
    private String Secant3;
    private String Steff1;
    private String Steff2;
    private String Steff3;

    public EventPanel(Object o) {
        super(o);
    }

    public EventPanel(Object o, String min, String max, String Bisection1,
            String Bisection2, String Bisection3, String NR1, String NR2,
            String NR3, String Secant1, String Secant2, String Secant3,
            String Steff1, String Steff2, String Steff3) {
        super(o);
        this.min = min;
        this.max = max;
        this.Bisection1 = Bisection1;
        this.Bisection2 = Bisection2;
        this.Bisection3 = Bisection3;
        this.NR1 = NR1;
        this.NR2 = NR2;
        this.NR3 = NR3;
        this.Secant1 = Secant1;
        this.Secant2 = Secant2;
        this.Secant3 = Secant3;
        this.Steff1 = Steff1;
        this.Steff2 = Steff2;
        this.Steff3 = Steff3;

    }

    public String getSteff3() {
        return Steff3;
    }

    public void setSteff3(String Steff3) {
        this.Steff3 = Steff3;
    }

    public String getSteff2() {
        return Steff2;
    }

    public void setSteff2(String Steff2) {
        this.Steff2 = Steff2;
    }

    public String getSteff1() {
        return Steff1;
    }

    public void setSteff1(String Steff1) {
        this.Steff1 = Steff1;
    }

    public String getSecant1() {
        return Secant1;
    }

    public void setSecant1(String Secant1) {
        this.Secant1 = Secant1;
    }

    public String getSecant2() {
        return Secant2;
    }

    public void setSecant2(String Secant2) {
        this.Secant2 = Secant2;
    }

    public String getSecant3() {
        return Secant3;
    }

    public void setSecant3(String Secant3) {
        this.Secant3 = Secant3;
    }

    public String getNR1() {
        return NR1;
    }

    public void setNR1(String NR1) {
        this.NR1 = NR1;
    }

    public String getNR2() {
        return NR2;
    }

    public void setNR2(String NR2) {
        this.NR2 = NR2;
    }

    public String getNR3() {
        return NR3;
    }

    public void setNR3(String NR3) {
        this.NR3 = NR3;
    }

    public String getBisection1() {
        return Bisection1;
    }

    public void setBisection1(String Bisection1) {
        this.Bisection1 = Bisection1;
    }

    public String getBisection2() {
        return Bisection2;
    }

    public void setBisection2(String Bisection2) {
        this.Bisection2 = Bisection2;
    }

    public String getBisection3() {
        return Bisection3;
    }

    public void setBisection3(String Bisection3) {
        this.Bisection3 = Bisection3;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

}
