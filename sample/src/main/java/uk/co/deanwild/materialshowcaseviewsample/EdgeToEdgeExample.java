package uk.co.deanwild.materialshowcaseviewsample;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class EdgeToEdgeExample extends AppCompatActivity {

    private static final String SHOWCASE_ID = "edge_to_edge_example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edge_to_edge_example);

        enableEdgeToEdge();

        Button topButton = findViewById(R.id.btn_top_edge);
        Button bottomButton = findViewById(R.id.btn_bottom_edge);

        presentShowcase(topButton, bottomButton);
    }

    private void enableEdgeToEdge() {
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(flags);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void presentShowcase(View topButton, View bottomButton) {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(300);

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);
        sequence.setConfig(config);
        sequence.addSequenceItem(topButton, "Spotlight should be centered on the top edge button.", "GOT IT");
        sequence.addSequenceItem(bottomButton, "Spotlight should be centered on the bottom edge button.", "GOT IT");
        sequence.start();
    }
}
