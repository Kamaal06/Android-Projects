package trial.of.tournamentact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class TournamentMap extends AppCompatActivity {

    ProgressBar pb;

    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_map);


        prog();
    }

    private void prog() {

        pb=(ProgressBar)findViewById(R.id.progBar);

        final Timer t = new Timer();
        TimerTask tt= new TimerTask() {
            @Override
            public void run() {

                counter++;
                pb.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };

        t.schedule(tt, 0,100);
    }


}
