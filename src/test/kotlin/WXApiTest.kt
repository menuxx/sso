import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.App
import com.yingtaohuo.wx.QrCodeInfo
import com.yingtaohuo.wx.WXLiteApi
import okio.Okio
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import java.io.File

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(App::class))
@WebAppConfiguration
class WXApiTest {

    @Test
    fun createWXQrcodeTest() {
        val mapper = ObjectMapper()
        val api = WXLiteApi(mapper)
        val accessToken = "NNi0_5Le5RJTG2FDpd0roYNJ6HFdRa7AFt6-DLfoyhILqFYhV1BFTatAabFDIaXgUhhcoEY6cAb8Xh8eXD6myBUd1Hzl4F7c5Wg49QQ-LuxSQMvsvqWz-uXT8pevIRT0RZTiAFDWEY"
        val info = QrCodeInfo("/pages/index/index", 430)
        val resp = api.createWXQrcode(accessToken, info)
        if ( resp.isSuccessful ) {
            val body = resp.body()
            if (body != null) {
                val buffer = Okio.buffer(Okio.sink(File("qrcode_with_args.jpg")))
                buffer.write(body.bytes())
                buffer.close()
            }
        }
    }

}