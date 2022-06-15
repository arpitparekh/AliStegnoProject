package arpit.alistegnoproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFileService extends Service {

    // https://file-examples.com/storage/fe7b61848062a91909a389b/2017/04/file_example_MP4_1920_18MG.mp4


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    URL url = new URL("https://file-examples.com/storage/fe7b61848062a91909a389b/2017/04/file_example_MP4_1920_18MG.mp4");

                    InputStream is = url.openStream();
                    DataInputStream dis = new DataInputStream(is);

                    byte arr[] = new byte[1024];

                    ////////////////////////////////////////////////

                    File rootPath = Environment.getExternalStorageDirectory(); // path of root folder

                    File subFolder = new File(rootPath,"NewAliFolder"); // subfolder path

                    subFolder.mkdir();  // make a folder

                    File file = new File(subFolder,"video.mp4");

                    FileOutputStream fos = new FileOutputStream(file);

                    /////////////////////////////////////////////////

                    int size;

//            size = dis.read(arr);

                    while((size= dis.read(arr))>0){

                        fos.write(arr,0,size);

                    }

                    Toast.makeText(DownloadFileService.this, "File Downloaded", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();




        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
