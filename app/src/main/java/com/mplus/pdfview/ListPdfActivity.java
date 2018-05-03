package com.mplus.pdfview;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ProgressBar;
import com.mplus.pdfview.adapter.CustomGridAdapter;
import com.mplus.pdfview.model.PDFData;
import java.io.File;
import java.util.ArrayList;

public class ListPdfActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pdf);
        setTitle("PDF Directory");

        final GridView gridView = findViewById(R.id.gvPdf);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        gridView.setAdapter(new CustomGridAdapter(ListPdfActivity.this,getPDF()){
        });
    }
    private ArrayList<PDFData> getPDF(){
        ArrayList<PDFData> pdfDocs = new ArrayList<>();
        //TARGET FOLDER
        File downloadsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        PDFData pdfDoc;

        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (File file : files) {
                if (file.getPath().endsWith("pdf")) {
                    pdfDoc = new PDFData();
                    pdfDoc.setName(file.getName());
                    pdfDoc.setPath(file.getAbsolutePath());

                    pdfDocs.add(pdfDoc);
                }

            }
        }

        return pdfDocs;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent about = new Intent(ListPdfActivity.this,About.class);
            startActivity(about);

        }
        return true;
    }
}
