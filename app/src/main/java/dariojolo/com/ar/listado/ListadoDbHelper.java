package dariojolo.com.ar.listado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ListadoDbHelper extends SQLiteOpenHelper {
    private static int version = 1;
    private static String name = "HipotecaDb" ;
    private static CursorFactory factory = null;

    public ListadoDbHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE BANCOS(" +
                " _id INTEGER PRIMARY KEY," +
                " ban_nombre TEXT NOT NULL, " +
                " ban_condiciones TEXT, " +
                " ban_contacto TEXT," +
                " ban_email TEXT," +
                " ban_telefono TEXT," +
                " ban_observaciones TEXT)" );

        db.execSQL( "CREATE UNIQUE INDEX ban_nombre ON BANCOS(ban_nombre ASC)" );

        Log.i(this.getClass().toString(), "Tabla BANCOS creada");

   /*
    * Insertamos datos iniciales
    */
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(1,'Santander')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(2,'BBVA')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(3,'La Caixa')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(4,'Cajamar')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(5,'Bankia')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(6,'Banco Sabadell')");
        db.execSQL("INSERT INTO BANCOS(_id, ban_nombre) VALUES(7,'Banco Popular')");

        Log.i(this.getClass().toString(), "Datos iniciales BANCOS insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
