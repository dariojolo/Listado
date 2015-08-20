package dariojolo.com.ar.listado;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends ListActivity  {

    private ListadoDbAdapter dbAdapter;
    private Cursor cursor;
    private ListadoCursorAdapter listadoAdapter ;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new ListadoDbAdapter(this);
        dbAdapter.abrir();

        consultar();
        ListadoDbHelper dbHelper = new ListadoDbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();
    }
    private void consultar()
    {
        cursor = dbAdapter.getCursor();
        startManagingCursor(cursor);
        listadoAdapter = new ListadoCursorAdapter(this, cursor);
        lista.setAdapter(listadoAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
