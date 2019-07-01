package org.holmes.probability;

public class Interval {
    public static int interval(String source, String target) {
        final String pat = String.format("[%s][^%s]*(?=[%s])", target, target, target);

        final String[] ss = source.split(pat);
        return ss.length;
    }
}
