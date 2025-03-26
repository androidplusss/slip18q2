package com.example.slip18q2;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button openMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        openMenu = findViewById(R.id.openMenu);
        registerForContextMenu(openMenu);
        openMenu.setOnLongClickListener(v -> {
            openContextMenu(v);
            return true;
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Operation");
        menu.add(0, v.getId(), 0, "Power");
        menu.add(0, v.getId(), 0, "Average");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        double result = 0;
        if (item.getTitle().equals("Power")) {
            result = Math.pow(number1, number2);
        } else if (item.getTitle().equals("Average")) {
            result = (number1 + number2) / 2.0;
        }
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
        return true;
    }
}
