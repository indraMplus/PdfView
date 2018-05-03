package com.mplus.pdfview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mplus.pdfview.ListPdfActivity;
import com.mplus.pdfview.MainActivity;
import com.mplus.pdfview.R;
import com.mplus.pdfview.model.PDFData;

import java.util.ArrayList;

public class CustomGridAdapter extends BaseAdapter {

    Context c;
    ArrayList<PDFData> pdfData;

    public CustomGridAdapter(Context c, ArrayList<PDFData> pdfData){
        this.c = c;
        this.pdfData = pdfData;
    }

    @Override
    public int getCount() {
        return pdfData.size();
    }

    @Override
    public Object getItem(int position) {
        return pdfData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            //INFLATE CUSTOM LAYOUT
            view = LayoutInflater.from(c).inflate(R.layout.grid_layout,parent,false);
        }
        final PDFData pdfData = (PDFData) this.getItem(position);

        TextView nameTxt= (TextView) view.findViewById(R.id.txtPDF);
        ImageView img= (ImageView) view.findViewById(R.id.imagePDF);

        //BIND DATA
        nameTxt.setText(pdfData.getName());
        img.setImageResource(R.drawable.pdfmdpi);

        //VIEW ITEM CLICK
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDFView(pdfData.getPath());
            }
        });
        return view;
    }

    //OPEN PDF VIEW
    private void openPDFView(String path)
    {
        Intent i = new Intent(c,MainActivity.class);
        i.putExtra("PATH",path);
        c.startActivity(i);
    }
}
