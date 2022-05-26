/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001013672_comp1555_coursework;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Abidon
 */
public class Bisection {

//Bisection x-x^2 calculation
    public String Bisectionnom(String xL, String xU) {
        double xlower, xupper, xnew, fxlower, fxupper, fxnew, diff;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");
        try {

            xlower = Double.parseDouble(xL);

            fxlower = xlower - Math.abs(xlower * xlower);

            xupper = Double.parseDouble(xU);

            fxupper = xupper - Math.abs(xupper * xupper);

            iteration = 0;

            do {
                iteration = iteration + 1;

                xnew = (xlower + xupper) / 2;
                fxnew = xnew - (xnew * xnew);

                System.out.println("BSnormal Approx for iteration: " + iteration + " is: " + xnew);
                diff = Math.abs(xupper - xlower) / 2;

                if (fxlower * fxnew > 0) {
                    xlower = xnew;
                    fxlower = fxnew;
                    break;

                } else if (fxupper * fxnew > 0) {
                    xupper = xnew;
                    fxupper = fxnew;
                    break;

                } else {
                    break;
                }

            } while (diff > 0.000001);
            String dans = DP.format(xnew);

            System.out.println("root to six decimal places is: " + dans + " original answer " + xnew);

            return dans;
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, " Please Enter a Numerical Value! >:( ");

        }
        return null;
    }

    //Bisection ln(x+1)+1 calculation
    public String Bisectionlog(String xL, String xU) {
        double diff1, xlower, xupper, lnupper, xlog, lnlower, fxlog;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xlower = Double.parseDouble(xL);
        lnlower = Math.log(xlower + 1) + 1;

        xupper = Double.parseDouble(xU);
        lnupper = Math.log(xupper + 1) + 1;

        iteration = 0;

        do {
            iteration = iteration + 1;

            xlog = (xlower + xupper) / 2;
            fxlog = Math.log(xlog + 1) + 1;
            System.out.println("BSlog Approx for iteration: " + iteration + " is: " + xlog);

            diff1 = Math.abs(lnupper - lnlower) / 2;

            if (lnlower * fxlog > 0) {
                xlower = xlog;
                lnlower = fxlog;
                break;

            } else if (lnupper * fxlog > 0) {
                xupper = xlog;
                lnupper = fxlog;
                break;

            } else {
                break;
            }

        } while (diff1 > 0.000001);
        String dans = DP.format(xlog);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xlog);

        return dans;
    }

    //Bisection e^x-3x calculation
    public String Bisectionexp(String xL, String xU) {
        double diff2, xlower, xupper, explower, expupper, xexp, fxexp;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xlower = Double.parseDouble(xL);
        explower = Math.exp(xlower) - 3 * xlower;

        xupper = Double.parseDouble(xU);
        expupper = Math.exp(xupper - 3 * xupper);

        iteration = 0;

        do {
            iteration = iteration + 1;

            xexp = (xlower + xupper) / 2;
            fxexp = Math.exp(xexp) - 3 * xexp;
            System.out.println("BSexp Approx for iteration: " + iteration + " is: " + xexp);

            diff2 = Math.abs(expupper - explower) / 2;

            if (explower * fxexp > 0) {
                xlower = xexp;
                explower = fxexp;
                break;

            } else if (expupper * fxexp > 0) {
                xupper = xexp;
                expupper = fxexp;
                break;
            } else {
                break;
            }

        } while (diff2 > 0.000001);
        String dans = DP.format(xexp);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xexp);
        return dans;

    }
}
