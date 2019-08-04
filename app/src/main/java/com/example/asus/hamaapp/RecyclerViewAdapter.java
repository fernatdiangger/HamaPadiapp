package com.example.asus.hamaapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyHolder>{

    String nama [] = {"Walang Sangit", "Tikus Sawah", "Wereng Coklat", "Penggerek batang padi putih", "Wereng Hijau", "Ulat Tentara"};
    int gambar [] = {R.drawable.hama_walang,
            R.drawable.hama_tikus,
            R.drawable.hama_wereng,
            R.drawable.penggerek,
            R.drawable.wereng_hijau,
            R.drawable.ulat};

    String latin [] = {"Leptocorisa Oratorius", "Rattus Argentiventer", "Nilaparvata lugens", "Scirpophaga Innotata", "Nephotettix Impicticeps", "Spodoptera Litura"};

    String detail [] = {"Serangga yang menjadi hama penting pada tanaman budidaya, terutama padi. Di Indonesia, serangga ini disebut: kungkang (Sunda), pianggang (Sumatera), dan tenang (Madura). Hewan ini mudah dikenali dari bentuknya yang memanjang, berukuran sekitar 2 cm, berwarna coklat kelabu, dan memiliki belalai (proboscis) untuk menghisap cairan tumbuhan. Walang sangit adalah anggota ordo Hemiptera (bangsa kepik sejati).",
            "Tikus berukuran sedang, cenderung lebih kecil daripada tikus got, dengan panjang 30-40cm (termasuk ekor). Warna rambut coklat kekuningan. Perutnya berambut kelabu dengan tepi putih. Nama argentiventer berarti berperut keperakan. Ekornya berwarna coklat.",
            "Salah satu hama padi yang paling berbahaya dan merugikan, terutama di daerah Asia Tenggara dan Asia Timur. Serangga kecil ini menghisap cairan tumbuhan dan sekaligus juga menyebarkan beberapa virus (terutama reovirus) yang menyebabkan penyakit tungro. Kumbang lembing memakan wereng dan anaknya sedangkan sejumlah lebah berperan sebagai pemangsa telurnya. Pemangsa alami ini dapat mengendalikan populasi wereng di bawah batas ambang populasi wereng terutama musim tanam dengan jumlah hama sedikit sehingga mencegah berjangkitnya virus utama.",
            "Ngengat yang termasuk dalam suku Crambidae. Larva hewan ini menjadi hama penting dalam budidaya padi. Gejala yang ditemukan sebelum padi berbunga disebut sebagai sundep dan gejala serangan yang dilakukan setelah malai keluar dikenal sebagai beluk.",
            "Merupakan hama penyebar (vektor) virus tungro yang menyebabkan penyakit tungro. Wereng jenis ini biasanya menetas pada pelepah daun padi dan akan menetas enam hari kemudian, menyukai cairan daun yg mengakibatkan pengeringan pada daun",
            "Tinggal di bawah permukaan tanah di siang hari dan aktif memakan tajuk tumbuhan pada malam hari. Serangannya dapat sangat hebat sehingga dalam waktu semalam dapat menghabiskan suatu pertanaman, dan oleh sebab itu dikenal sebagai ulat tentara"};

    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter (Context context ){

        this.context = context;
        layoutInflater = layoutInflater.from(context);

    }
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_item_hama, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        // ini berfungsi untuk mengirim data ke DetailActivity
        holder.txt.setText(nama [position]);
        holder.latin.setText(latin [position]);
        holder.img.setImageResource(gambar [position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimData = new Intent(context, DetailActivity.class);
                kirimData.putExtra("Nama", nama [position]);
                kirimData.putExtra("IMG", gambar [position]);
                kirimData.putExtra("DET", detail [position]);
                kirimData.putExtra("LAT", latin [position]);

                context.startActivity(kirimData);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nama.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        // ID ini diambil dari file list_item.xml
        ImageView img;
        TextView txt;
        TextView latin;
        Button sharee;

        public MyHolder(View itemView) {

            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imglist);
            txt = (TextView) itemView.findViewById(R.id.txtlist);
            latin = (TextView) itemView.findViewById(R.id.nama_latin);
            sharee = (Button) itemView.findViewById(R.id.share);

            sharee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Semoga Bermanfaat",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}