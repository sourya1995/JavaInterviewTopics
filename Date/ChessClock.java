package Date;

import java.time.Instant;
import java.io.Serializable;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZoneOffset;





public class ChessClock extends Clock implements Serializable {

    public enum Player {
        LEFT, 
        RIGHT
    }

    private static final long serialVersionUID = 1L;

    private Instant instantStart;
    private Instant instantRight;
    private Instant instantLeft;

    private Player player;
    private long timeLeft;
    private long timeRight;

    public ChessClock(Player player) {
        this.player = player;
    }

    public Instant gameStart() {
        if(this.instantStart == null){
            this.timeLeft = 0;
            this.timeRight = 0;
            this.instantStart = Instant.now();
            this.instantLeft = instantStart;
            this.instantRight = instantStart;
            return instantStart;
        }

        throw new IllegalStateException("Game already started");

    }

    public Instant gameEnd() {
        if(this.instantStart != null){
            instantStart = null;
            return Instant.now();
        }

        throw new IllegalStateException("Game not started");
    }

    @Override
    public ZoneId getZone() {
        return ZoneOffset.UTC;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Instant instant() {
        if(this.instantStart != null){
            if(player == Player.LEFT){
                player = Player.RIGHT;
                long secondsLeft = Instant.now().getEpochSecond() - instantRight.getEpochSecond();
                instantLeft = instantLeft.plusSeconds( - timeLeft);
                timeLeft = secondsLeft;
                return instantLeft;

            }else{
                player = Player.LEFT;
                long secondsRight = Instant.now().getEpochSecond() - instantLeft.getEpochSecond();
                instantRight = instantRight.plusSeconds( secondsRight - timeRight);
                timeRight = secondsRight;
                return instantRight;
            }
        }

        throw new IllegalStateException("Game not started");
    }

    
}







    

