import synthesizer.GuitarString;

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString[] guitar = new GuitarString[37];

        for(int i=0; i<37; i++) {
            guitar[i] = new GuitarString(440.0 * Math.pow(2.0, (i-24.0) / 12.0));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if(index>-1) {
                    guitar[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for(int i=0; i<37; i++) {
                sample += guitar[i].sample();
            }
            sample = sample / 37;

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(int i=0; i<37; i++) {
                guitar[i].tic();
            }

        }
    }
}
