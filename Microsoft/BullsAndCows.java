class BullsAndCows {
    public String getHint(String secret, String guess) {
        int len = secret.length() < guess.length() ? secret.length() : guess.length();
        int gStore[] = new int[10];
        int sStore[] = new int[10];

        int bulls = 0, cows = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                sStore[secret.charAt(i) - '0']++;
                gStore[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(gStore[i], sStore[i]);
        }

        return bulls + "A" + cows + "B";
    }
}