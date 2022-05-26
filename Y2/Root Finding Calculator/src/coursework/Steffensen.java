package coursework;

import java.text.DecimalFormat;

/**
 *
 * @author Abidon Jude Fernandes
 */
public class Steffensen {

    //Steffensen x-x^2 calculation
    public String Steffensennom(String xO) {

        double diff, xold, fxold, newxold, xnew;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;

        do {
            iteration = iteration + 1;
            fxold = xold - (xold * xold);
            newxold = (fxold - xold) / xold;

            xnew = (fxold - xold) / newxold;

            System.out.println("Steffnormal Approx for iteration " + iteration + "is " + xnew);

            diff = Math.abs(xnew - xold);
            xold = xnew;
            if (xnew == xold) {
                break;
            }

        } while (diff > 0.000001);

        String dans = DP.format(xnew);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xnew);

        return dans;
    }

    //Steffensen ln(x+1)+1 calculation
    public String Steffensenlog(String xO) {

        double diff1, xold, fxold, newxold, xlog;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;

        do {
            iteration = iteration + 1;
            fxold = Math.log(xold + 1) + 1;
            newxold = (fxold - xold) / xold;

            xlog = (fxold - xold) / newxold;

            System.out.println("Stefflog Approx for iteration " + iteration + "is " + xlog);

            diff1 = Math.abs(xlog - xold);
            xold = xlog;
            if (xlog == xold) {
                break;
            }

        } while (diff1 > 0.000001);

        String dans = DP.format(xlog);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xlog);

        return dans;
    }

    //Steffensen e^x-3x calculation
    public String Steffensenexp(String xO) {

        double diff2, xold, fxold, newxold, xexp;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;

        do {
            iteration = iteration + 1;
            fxold = Math.exp(xold) - 3 * xold;
            newxold = (fxold - xold) / xold;

            xexp = (fxold - xold) / newxold;

            System.out.println("Steffexp Approx for iteration " + iteration + "is " + xexp);

            diff2 = Math.abs(xexp - xold);
            xold = xexp;
            if (xexp == xold) {
                break;
            }

        } while (diff2 > 0.000001);

        String dans = DP.format(xexp);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xexp);

        return dans;
    }
}
