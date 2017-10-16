import com.google.common.io.Resources
import com.google.zxing.BinaryBitmap
import com.google.zxing.Result
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeReader
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Test
import javax.imageio.ImageIO
import org.yaml.snakeyaml.reader.ReaderException
import qiniu.happydns.util.Hex
import java.net.URLEncoder


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */

class QrCodeTest {

    @Test
    fun decoder() {

        // https://github.com/zxing/zxing

        val str = "安达市大所多"

        val strEncode = URLEncoder.encode(str, "UTF-8")
        val strEncode2 = URLEncoder.encode(strEncode, "UTF-8")

        val http = OkHttpClient.Builder().build()

        val req = Request.Builder()
                .get()
                .url("https://qr.api.cli.im/qr?data=$strEncode2&level=H&transparent=false&bgcolor=%23ffffff&forecolor=%23000000&blockpixel=12&marginblock=1&logourl=&size=280&kid=cliim&key=d8b8f32d2c72f3991a7fe9a06a815e72")
                .build()

        val resp = http.newCall(req).execute()

        if ( resp.isSuccessful ) {

            // gh_87e8a8151cf9_258.jpg

            val image = ImageIO.read(Resources.getResource("gh_87e8a8151cf9_258.jpg"))

            // val image = ImageIO.read(resp.body().byteStream())

            val source = BufferedImageLuminanceSource(image)

            val bitmap = BinaryBitmap(HybridBinarizer(source))

            //decode the barcode
            val reader = QRCodeReader()

            val result: Result
            try {
                // val hints = mutableMapOf<EncodeHintType, Any>()
                result = reader.decode(bitmap)
                println(result.text)
                println(Hex.encodeHexString(result.rawBytes))
            } catch (e: ReaderException) {
                //the data is improperly formatted
                e.printStackTrace()
            }
        } else {

            println(resp.message())

        }

    }

}