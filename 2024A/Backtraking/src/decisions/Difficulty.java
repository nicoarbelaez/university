package decisions;

public enum Difficulty {
    EASY, MEDIUM, HARD, MASTER, EXPERT;

    int getNumberOfHints(int numberOfRegions) {
        int min = 0;
        switch (this) {
            case EASY:
                min = numberOfRegions * numberOfRegions / 2;
                break;
            case MEDIUM:
                min = numberOfRegions * numberOfRegions / 3;
                break;
            case HARD:
                min = numberOfRegions * numberOfRegions / 5;
                break;
            case MASTER:
                min = numberOfRegions * numberOfRegions / 7;
                break;
            case EXPERT:
                min = numberOfRegions * numberOfRegions / 8;
                break;
            default:
                min = numberOfRegions * numberOfRegions / 2;
                break;
        }

        int max = min + 5;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
