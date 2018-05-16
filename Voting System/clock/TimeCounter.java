package clock;

import pkg1.VotingGui;
import pkg1.ModeratorGui;
import java.util.Timer;
import java.util.TimerTask;

public class TimeCounter {
    Timer timer;
	VotingGui vg1=new VotingGui();
    public TimeCounter(int seconds) {
        timer = new Timer();
        timer.schedule(new votingtime(), seconds*1000);
	}

    class votingtime extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
		    vg1.votingframe.setVisible(false);

        }
    }
}