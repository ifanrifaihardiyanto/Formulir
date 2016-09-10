package id.sch.smktelkom_mlg.learn.formulir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTgl;
    EditText etAsal;
    EditText etTujuan;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTgl = (EditText) findViewById(R.id.editTextTgl);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        etAsal.setText("");
        etTgl.setText("");
        etTujuan.setText("");

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgl = etTgl.getText().toString();
                String Asal = etAsal.getText().toString();
                String Tujuan = etTujuan.getText().toString();
                tvHasil.setText(tgl + "\n" + Asal + "\n" + Tujuan);
            }
        });
    }
}
