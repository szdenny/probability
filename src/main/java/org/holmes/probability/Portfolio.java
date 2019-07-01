package org.holmes.probability;

import java.util.Random;

import org.apache.commons.cli.*;

import static java.lang.Math.log10;

/**
 *
 */
public class Portfolio {
    private static double p = 0.7;
    private static double q = 0.7;
    private static double rate = 2.0;
    public static Random r = new Random();

    public static double trial(int times) {
        for (int i = 0; i < times; i++) {
            sum(0);
        }
        return 0;
    }

    public static double sum(double x) {
        return (r.nextFloat() > q) ? (log10(p) + log10(rate)) : (log10(1 - p) + log10(rate));
    }

    public static void main(String[] args) {
        Options options = new Options();

        options.addOption("p", "p", true, "-p 0.7");
        options.addOption("q", "q", true, "-q 0.7");
        options.addOption("t", "turn", true, "-t 100");
        options.addOption("s", "seed", true, "-s 777");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            p = Float.parseFloat(cmd.getOptionValue("p", "0.7"));
            q = Float.parseFloat(cmd.getOptionValue("q", "0.7"));
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("abc def", options);
            System.exit(1);
        }


    }
}
