package lab14;

import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;
    private int max;
    private int min = 0;

    public StrangeBitwiseGenerator(int period) {
        this.state = 0;
        this.period = period;
    }

    public double next() {
        state = (state + 1);
        int weirdState = state & (state >>> 3) % period;
        max = max > Math.abs(weirdState) ? max : Math.abs(weirdState);
        if (max != 0) {
            double res = (double) weirdState / (double) max;
            return res;
        }
        return weirdState;
    }
}
