package dariojolo.com.ar.listado;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
public class ListadoDbAdapter {
    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "BANCOS" ;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_COLUMNA_ID   = "_id";
    public static final String C_COLUMNA_NOMBRE = "ban_nombre";
    public static final String C_COLUMNA_CONDICIONES = "ban_condiciones";
    public static final String C_COLUMNA_CONTACTO = "ban_contacto";
    public static final String C_COLUMNA_EMAIL = "ban_email";
    public static final String C_COLUMNA_TELEFONO = "ban_telefono";
    public static final String C_COLUMNA_OBSERVACIONES = "ban_observaciones";

    private Context contexto;
    private ListadoDbHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_CONDICIONES, C_COLUMNA_CONTACTO, C_COLUMNA_EMAIL, C_COLUMNA_TELEFONO, C_COLUMNA_OBSERVACIONES} ;

    public ListadoDbAdapter(Context context)
    {
        this.contexto = context;
    }

    public ListadoDbAdapter abrir() throws SQLException
    {
        dbHelper = new ListadoDbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todos las columnas de la tabla
     */
    public Cursor getCursor() throws SQLException
    {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);

        return c;
    }
}
