package com.ahl.notifapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ahl.appnotif.AppNotif;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            new AppNotif.Builder(MainActivity.this)
                    .title("Notifikasi Cancel")
                    .message("Akan terdapat action jika user melakukan cancel terhadap notifikasi (klik bagian luar notifikasi untuk melihat)")
                    .setCancelListener(new AppNotif.Listener() {
                       @Override
                       public void onClick(AppNotif appNotif) {
                          Toast.makeText(getApplicationContext(), "Notifikasi Cancel", Toast.LENGTH_SHORT).show();
                       }
                    })
                    .build().show();
         }
      });

      findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            new AppNotif.Builder(MainActivity.this)
                    .title("Notifikasi Panjang")
                    .message("Seberapa panjangpun notifikasi yang ingin ditampilkan pada aplikasi, extend notifikasi IOS ini tetap bisa menampungnya dengan baik dan sempurna.\nExtend notifikasi IOS ini membuat aplikasi anda menjadi semakin menarik dan elegant.")
                    .setCancelListener(new AppNotif.Listener() {
                       @Override
                       public void onClick(AppNotif appNotif) {
                          appNotif.dismiss();
                       }
                    })
                    .build().show();
         }
      });

      findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            new AppNotif.Builder(MainActivity.this)
                    .title("Notifikasi Fokus")
                    .message("Notifikasi tidak akan tertutup walaupun bagian luar notifikasi di klik")
                    .cancelable(false)
                    .build().show();
         }
      });

      findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            new AppNotif.Builder(MainActivity.this)
                    .title("Notifikasi Link Direct")
                    .message("Notifikasi untuk membuka suatu link. Contoh notifikasi ini akan mengarahkan anda untuk membuka obrolan chat di Telegram")
                    .setPositiveClickListener("Oke", new AppNotif.Listener() {
                       @Override
                       public void onClick(AppNotif appNotif) {
                          Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/aguzstiar"));
                          startActivity(browserIntent);
                          appNotif.dismiss();
                       }
                    })
                    .build().show();
         }
      });

      findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            new AppNotif.Builder(MainActivity.this)
                    .title("Notifikasi Pilihan")
                    .message("Notifikasi yang memberikan pilihan kepada user. Contoh notifikasi ini akan meminta konfirmasi kepada user untuk memenutup aplikasi")
                    .setPositiveClickListener("Yes", new AppNotif.Listener() {
                       @Override
                       public void onClick(AppNotif appNotif) {
                          appNotif.dismiss();
                          finish();
                       }
                    })
                    .setNegativeClickListener("No", new AppNotif.Listener() {
                       @Override
                       public void onClick(AppNotif appNotif) {
                          appNotif.dismiss();
                       }
                    })
                    .build().show();
         }
      });
   }
}