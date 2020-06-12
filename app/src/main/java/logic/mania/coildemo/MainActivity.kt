package logic.mania.coildemo

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.LoadRequest
import com.example.koildemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageLoader = ImageLoader.Builder(applicationContext)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
            .build()

        val request = LoadRequest.Builder(img_1.context)
            .crossfade(true)
            .data("https://api.androidhive.info/images/food/1.jpg")
            .target(img_1)
            .build()
        imageLoader.execute(request)

        val request_2 = LoadRequest.Builder(img_1.context)
            .data("https://media.giphy.com/media/IIv3NuURRxgJO/giphy.gif")
            .target(img_2)
            .build()
        imageLoader.execute(request_2)



    }
}