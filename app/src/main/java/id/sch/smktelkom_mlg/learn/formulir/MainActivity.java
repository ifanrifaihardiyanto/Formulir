package id.sch.smktelkom_mlg.learn.formulir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*EditText etTgl;
    EditText etAsal;
    EditText etTujuan;*/
    Button bOK;
    TextView tvHasil;
    RadioButton rbEks, rbBis, rbEk;
    CheckBox cbDew, cbAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* etTgl = (EditText) findViewById(R.id.editTextTgl);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);*/
//        bOK = (Button) findViewById(R.id.buttonOK);
        rbEks = (RadioButton) findViewById(R.id.radioButtonEks);
        rbBis = (RadioButton) findViewById(R.id.radioButtonBis);
        rbEk = (RadioButton) findViewById(R.id.radioButtonEk);
        /*etAsal.setText("");
        etTgl.setText("");
        etTujuan.setText("");*/
        cbDew = (CheckBox) findViewById(R.id.checkBoxDew);
        cbAn = (CheckBox) findViewById(R.id.checkBoxAn);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

       /* bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgl = etTgl.getText().toString();
                String Asal = etAsal.getText().toString();
                String Tujuan = etTujuan.getText().toString();
                tvHasil.setText(tgl + "\n" + Asal + "\n" + Tujuan);
                doProses();
            }

            private void doProses() {
                if (isValid()) {
                    String tgl = etTgl.getText().toString();
                    String Asal = etAsal.getText().toString();
                    String Tujuan = etTujuan.getText().toString();
                    tvHasil.setText(tgl + "\n" + Asal + "\n" + Tujuan);
                }
            }

            private boolean isValid() {
                boolean valid = true;

                String Tanggal = etTgl.getText().toString();
                String  Asal = etAsal.getText().toString();
                String  Tujuan = etTujuan.getText().toString();

                if (Tanggal.isEmpty())
                {
                    etTgl.setError("Tidak Boleh Kosong");
                    valid = false;
                }
                else
                {
                    etTgl.setError(null);
                }

                if (Asal.isEmpty())
                {
                    etAsal.setError("Tidak Boleh Kosong!");
                    valid = false;
                }
                else
                {
                    etAsal.setError(null);
                }

                if (Tujuan.isEmpty())
                {
                    etTujuan.setError("Tidak Boleh Kosong!");
                }
                else
                {
                    etTujuan.setError(null);
                }
                return valid;
            }
        });*/

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
                Click();
            }
        });

    }

    private void doClick() {
        String hasil = null;

        if (rbEks.isChecked()) {
            hasil = rbEks.getText().toString();
        } else if (rbBis.isChecked()) {
            hasil = rbBis.getText().toString();
        } else if (rbEk.isChecked()) {
            hasil = rbEk.getText().toString();
        }

        if (hasil == null) {
            tvHasil.setText("Anda Belum Memilih");
        } else {
            tvHasil.setText("Kelas :" + hasil);
        }

    }

    private void Click() {
        String hasil = "Usia:\n";
        int startlen = hasil.length();
        if (cbDew.isChecked()) hasil += cbDew.getText() + "\n";
        if (cbAn.isChecked()) hasil += cbAn.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak";

        tvHasil.setText(hasil);
    }
}