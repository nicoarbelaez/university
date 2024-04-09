package reader;

import game.message.GameMessages;
import models.TrackNumber;

public interface InputReader {
    void setTrackNumber(TrackNumber trackNumber);
    int readUserInput(int min, int max, GameMessages message);
    void reset();
}
