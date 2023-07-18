package com.example.pm012p2023.Config;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pm012p2023.R;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Empleado> implements View.OnClickListener
{
    private List<Empleado> dataSet;
    private Context context;

    public static class ViewHolder
    {
        TextView txtapellidos;
        TextView txtnombres;
        ImageView ImageEmple;
    }


    public CustomAdapter(List<Empleado> data, Context context) {
        super(context, R.layout.row_emple, data);
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public void onClick(View view) {

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Empleado dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_emple, parent, false);
            viewHolder.txtapellidos = (TextView) convertView.findViewById(R.id.empleapellido);
            viewHolder.txtnombres = (TextView) convertView.findViewById(R.id.nameemple);
            viewHolder.ImageEmple = (ImageView) convertView.findViewById(R.id.empleimage);

            result=convertView;
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtapellidos.setText(dataModel.getApellidos());
        viewHolder.txtnombres.setText(dataModel.getNombres());
        viewHolder.ImageEmple.setImageBitmap(ConvertBase64toImage(dataModel.getFoto()));
        return convertView;
    }



    private Bitmap ConvertBase64toImage(String Base64String)
    {
        String base64Image = Base64String.split(",")[1];
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    private Bitmap convertBase64ToBitmap(String b64) {
        byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }
}
