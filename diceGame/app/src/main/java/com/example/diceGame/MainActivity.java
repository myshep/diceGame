package com.example.diceGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    ImageView ivDice1, ivDice2, ivDice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivDice1 = (ImageView)findViewById(R.id.ivDice1);
        ivDice2 = (ImageView)findViewById(R.id.ivDice2);
        ivDice3 = (ImageView)findViewById(R.id.ivDice3);

    }

    public void RollDice(View view) {
        Toast.makeText(this, "또르르~~~", Toast.LENGTH_SHORT).show();

        final Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anim);
        final Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anim);
        final Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anim);

        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                changeDice(animation);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changeDice(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                changeDice(animation);
            }


            private void changeDice(Animation animation) {
                int value = randomDiceValue();
                int res = getResources().getIdentifier("dice_" + value, "drawable", "com.example.diceGame");

                if (animation == animation1) {
                    ivDice1.setImageResource(res);
                } else if (animation == animation2) {
                    ivDice2.setImageResource(res);
                } else if (animation == animation3) {
                    ivDice3.setImageResource(res);
                }
            }
        };

        animation1.setAnimationListener(animationListener);
        animation2.setAnimationListener(animationListener);
        animation3.setAnimationListener(animationListener);

        ivDice1.startAnimation(animation1);
        ivDice2.startAnimation(animation2);
        ivDice3.startAnimation(animation3);
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

}
