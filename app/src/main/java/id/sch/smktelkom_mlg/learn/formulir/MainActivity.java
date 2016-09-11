package id.sch.smktelkom_mlg.learn.formulir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNm;
    EditText etAsal;
    EditText etTujuan;
    EditText etTanggal;
    Button bOK;
    TextView tvHasil, tvkereta;
    RadioButton rbEks, rbBis, rbEk;
    RadioGroup rgKelas;
    CheckBox cbDew, cbAn;
    Spinner spK;
    int nKereta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNm = (EditText) findViewById(R.id.editTextNm);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        bOK = (Button) findViewById(R.id.buttonOK);
        rbEks = (RadioButton) findViewById(R.id.radioButtonEks);
        rbBis = (RadioButton) findViewById(R.id.radioButtonBis);
        rbEk = (RadioButton) findViewById(R.id.radioButtonEk);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        cbDew = (CheckBox) findViewById(R.id.checkBoxDew);
        cbAn = (CheckBox) findViewById(R.id.checkBoxAn);
        cbDew.setOnCheckedChangeListener(this);
        cbAn.setOnCheckedChangeListener(this);
        spK = (Spinner) findViewById(R.id.spinnerKereta);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvkereta = (TextView) findViewById(R.id.textViewNmK);


        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
        }
        });

    }

    private void doClick() {
        String nama = etNm.getText().toString();
        String Asal = etAsal.getText().toString();
        String Tujuan = etTujuan.getText().toString();
        String Tanggal = etTanggal.getText().toString();
        String hasil = null;
        String NmK = spK.getSelectedItem().toString();
        String Kereta = "\n Kereta";

        int startlen = Kereta.length();
        if (cbDew.isChecked()) Kereta += cbDew.getText() + ",";
        if (cbAn.isChecked()) Kereta += cbAn.getText() + ",";

        if (Kereta.length() == startlen) Kereta = "Tidak Ada Pada Pilihan";

        if (rgKelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgKelas.getCheckedRadioButtonId());

            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNm.setError("Nama Belum Diisi");
        } else if (nama.length() < 20) {
            etNm.setError("Nama Minimal 20 Karakter");
        } else {
            etNm.setError(null);
        }

        if (Asal.isEmpty()) {
            etAsal.setError("Belum Diisi");
        } else if (Asal.length() < 4) {
            etAsal.setError("Minimal 4 Karakter");
        } else {
            etAsal.setError(null);
        }

        if (Tujuan.isEmpty()) {
            etTujuan.setError("Belum Diisi");
        } else if (Tujuan.length() < 4) {
            etTujuan.setError("Minimal 4 Karakter");
        } else {
            etTujuan.setError(null);
        }

        if (Tanggal.isEmpty()) {
            etTanggal.setError("Belum Diisi");
        } else if (Tanggal.length() < 10) {
            etTanggal.setError("Minimal 10 Karakter");
        } else {
            etTanggal.setError(null);
        }

        tvHasil.setText("----------------- PEMBELIAN BERHASIL -----------------" +
                "\nNama                                   : " + nama +
                "\nAsal                                      : " + Asal +
                "\nTujuan                                 : " + Tujuan +
                "\nTanggal Keberangkatan : " + Tanggal +
                "\nKelas                                    : " + hasil +
                "\nUsia                                      : " + Kereta +
                "\nNama Kereta                      : " + NmK);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nKereta += 1;
        else nKereta -= 1;
        tvkereta.setText("Hobi (" + nKereta + " Terpilih ");
    }
}