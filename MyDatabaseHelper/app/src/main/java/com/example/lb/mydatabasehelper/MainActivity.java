package com.example.lb.mydatabasehelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        Button addData = (Button) findViewById(R.id.add_data);
        Button updateData = (Button)findViewById(R.id.update_data);
        Button deleteButton = (Button) findViewById(R.id.delete_data);
        Button queryButton = (Button) findViewById(R.id.query_data);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                values.put("price",16.66);
                db.insert("Book",null,values);
                values.clear();

                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages",510);
                values.put("price",19.95);
                db.insert("Book",null,values);

                db.execSQL("insert into Book(name, author, pages, price) values(?,?,?,?)",
                        new String[] {"Code1","DanBrown","454","16.96"});

                db.execSQL("insert into Book(name, author, pages, price) values(?,?,?,?)",
                        new String[] {"Code2","DanBrown","666","1989.96"});
            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",13456.21312312);
                db.update("Book",values, "name = ?",new String[] {"The Da Vinci Code"});

                db.execSQL("update Book set price = ? where name = ?",new String[]{"10.99"});

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","pages > ?",new String[]{"500"});

                db.execSQL("delete from Book where pages > ?",new String[] {"500"});
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询Boos表中所有的数据
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        //遍历 Cursor 对象,取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getInt(cursor.getColumnIndex("price"));
                        Log.d(TAG, "Book name is " + name);
                        Log.d(TAG, "book author is " + author);
                        Log.d(TAG, "book pages is " + pages);
                        Log.d(TAG, "book price is "+ price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }

}
