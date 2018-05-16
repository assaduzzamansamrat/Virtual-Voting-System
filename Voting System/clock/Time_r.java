package clock;

import pkg1.VotingGui;
import pkg1.ModeratorGui;
import java.util.Timer;
import java.util.TimerTask;
import pkg1.setTimeGui;
import pkg1.Result;

public class Time_r {
    Timer timer;
	ModeratorGui mg1=new ModeratorGui();
    public Time_r(int time) {
        timer = new Timer();
        timer.schedule(new votingtime(), time*1000);
		setTimeGui.messageFrame.setVisible(false);
	}

    class votingtime extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
		    mg1.ModeratorFrame.setVisible(false);
            Result rss=new Result();
        }
    }
}