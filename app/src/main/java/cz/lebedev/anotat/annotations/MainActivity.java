package cz.lebedev.anotat.annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cz.lebedev.anotat.lib.Binding;
import cz.lebedev.anotat.lib_annotations.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Binding.bind(this);
        //ViewBinder.bind(this);
        txtView.setText("annotation works");
    }
}
