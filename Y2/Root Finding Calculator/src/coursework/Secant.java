/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001013672_comp1555_coursework;

import java.text.DecimalFormat;

/**
 *
 * @author Abido
 */
public class Secant {

    //Secant x-x^2 calculation
    public String Secantnom(String xo1, String xo2) {
        double xold1, xold2, xnew, fxold1, fxold2, diff;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold1 = Double.parseDouble(xo1);
        xold2 = Double.parseDouble(xo2);
        iteration = 0;
        do {
            iteration = iteration + 1;

            fxold1 = xold1 - (xold1 * 2);
            fxold2 = xold2 - (xold2 * 2);

            xnew = xold1 - (fxold1 * (xold1 - xold2)) / (fxold1 - fxold2);

            System.out.println("SEnormal Approx for iteration " + iteration + " is " + xnew);

            diff = Math.abs(xnew - xold1);

            xold2 = xold1;
            xold1 = xnew;

            if (xold1 == xnew) {
                break;
            }
        } while (diff > 0.000001);
        String dans = DP.format(xnew);
        System.out.println("root to six decimal places is: " + dans + " original answer " + xnew);

        return dans;

    }

    //Secant ln(x+1)+1 calculation
    public String Secantlog(String xo1, String xo2) {
        double xold1, xold2, lxold1, lxold2, xlog, diff1;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold1 = Double.parseDouble(xo1);
        xold2 = Double.parseDouble(xo2);
        iteration = 0;

        do {
            iteration = iteration + 1;

            lxold1 = Math.log(xold1 + 1) + 1;
            lxold2 = Math.log(xold2 + 1) + 1;

            xlog = xold1 - (lxold1 * (xold1 - xold2)) / (lxold1 - lxold2);

            System.out.println("SElog Approx for iteration " + iteration + " is " + xlog);

            diff1 = Math.abs(xlog - xold1);

            xold2 = xold1;
            xold1 = xlog;

            if (xold1 == xlog) {
                break;
            }
        } while (diff1 > 0.000001);

        String dans = DP.format(xlog);
        System.out.println("root to six decimal places is: " + dans + " original answer " + xlog);

        return dans;
    }

    //Secant e^x-3x calculation
    public String Secantexp(String xo1, String xo2) {
        double xold1, xold2, exold1, exold2, xexp, diff2;
        int iteration;
        DecimalFormat DP = new DecimalFormat("0.000000");

        xold1 = Double.parseDouble(xo1);
        xold2 = Double.parseDouble(xo2);
        iteration = 0;

        do {
            iteration = iteration + 1;

            exold1 = Math.exp(xold1 - 3 * xold1);
            exold2 = Math.exp(xold2 - 3 * xold2);

            xexp = xold1 - (exold1 * (xold1 - xold2)) / (exold1 - exold2);

            System.out.println("SEexp Approx for iteration " + iteration + " is " + xexp);

            diff2 = Math.abs(xexp - xold1);

            xold2 = xold1;
            xold1 = xexp;

            if (xold1 == xexp) {
                break;
            }
        } while (diff2 > 0.000001);
        String dans = DP.format(xexp);

        System.out.println("root to six decimal places is: " + dans + " original answer " + xexp);

        return dans;
    }

}
