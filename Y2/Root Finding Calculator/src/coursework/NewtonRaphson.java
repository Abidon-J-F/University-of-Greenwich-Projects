package coursework;

import java.text.DecimalFormat;

/**
 *
 * @author Abidon Jude Fernandes
 */
public class NewtonRaphson {

    //NewtonRaphson x-x^2 calculation
    public String NewtonRaphsonnom(String xO) {
        double xold, xnew, fxold, fdxold, diff;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;
        do {
            iteration = iteration + 1;

            fxold = xold - (xold * xold);
            fdxold = 1.0 + (xold);

            xnew = -(fxold / fdxold);

            System.out.println("NRnormal Approx for iteration " + iteration + "is " + xnew);

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

    //NewtonRaphson ln(x+1)+1 calculation
    public String NewtonRaphsonlog(String xO) {
        double diff1, xold, lnold, xlog, fxlog, fdlog;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;

        do {
            iteration = iteration + 1;

            fxlog = Math.log(xold + 1) + 1;
            fdlog = 1.0 + (xold);

            xlog = -(fxlog / fdlog);

            System.out.println("NRlog Approx for iteration " + iteration + "is " + xlog);

            diff1 = Math.abs(xlog - xold);
            lnold = xlog;

            if (xlog == lnold) {
                break;
            }
        } while (diff1 > 0.000001);
        String dans = DP.format(xlog);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xlog);

        return dans;
    }

    //NewtonRaphson e^x-3x calculation
    public String NewtonRaphsonexp(String xO) {
        double diff2, xold, expold, fdexp, xexp, fxexp;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold = Double.parseDouble(xO);
        iteration = 0;

        do {

            iteration = iteration + 1;

            fxexp = (xold) - 3 * xold;
            fdexp = 1.0 + (xold);

            xexp = -(fxexp / fdexp);

            System.out.println("NRexp Approx for iteration " + iteration + "is " + xexp);

            diff2 = Math.abs(xexp - xold);
            expold = xexp;

            if (xexp == expold) {
                break;
            }
        } while (diff2 > 0.000001);
        String dans = DP.format(xexp);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xexp);

        return dans;

    }
}
