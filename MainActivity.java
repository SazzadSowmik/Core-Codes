package helloworldapp.com.example.sowmik.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player {
        ONE, TWO, No
    }

    Player currentPlayer = Player.ONE;
    Player[] playerChoices = new Player[9];


    int winnerRowsColumns[][] = {{0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {3, 4, 5}, {6, 7, 8}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}};

    boolean gameOver = false;
    private Button btnReset;
   
    private android.support.v7.widget.GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 9; i++) {
            playerChoices[i] = Player.No;
        }
        btnReset = findViewById(R.id.btnReset);
        gridLayout = findViewById(R.id.gridLayout);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               resetFunction();
            }
        });
    }

    public void imageViewIsTapperd(View imageView) {
        ImageView tappedImageView = (ImageView) imageView;

        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        if (playerChoices[tiTag] == Player.No && gameOver == false) {
            tappedImageView.setTranslationX(-2000);
            playerChoices[tiTag] = currentPlayer;
            if (currentPlayer == Player.ONE) {
                tappedImageView.setImageResource(R.drawable.cat);
                currentPlayer = Player.TWO;
            } else if (currentPlayer == Player.TWO) {
                tappedImageView.setImageResource(R.drawable.dog);
                currentPlayer = Player.ONE;
            }
            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            Toast.makeText(getApplicationContext(), tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();

            for (int[] winnerColumn : winnerRowsColumns) {
                if (playerChoices[winnerColumn[0]] == playerChoices[winnerColumn[1]] &&
                        playerChoices[winnerColumn[1]] == playerChoices[winnerColumn[2]] &&
                        playerChoices[winnerColumn[0]] != Player.No) {

                    String winnerOfTheGame = "";
                    gameOver = true;
                    btnReset.setVisibility(View.VISIBLE);

                    if (currentPlayer == Player.ONE) {
                        winnerOfTheGame = "DOG";
                        Toast.makeText(this, "Winner Winner Bone Dinner for " + winnerOfTheGame + "!!!", Toast.LENGTH_LONG).show();

                    } else if (currentPlayer == Player.TWO) {
                        winnerOfTheGame = "CAT";
                        Toast.makeText(this, "Winner Winner Fish Dinner for " + winnerOfTheGame + "!!!", Toast.LENGTH_LONG).show();

                    }

                }
            }

        }

    }

    //Reset button
    public void resetFunction (){
        for (int index=0;index<gridLayout.getChildCount();index++){
            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }
        currentPlayer = Player.ONE;

        for (int i = 0; i < 9; i++) {
            playerChoices[i] = Player.No;
        }
        gameOver = false;
    }
}




