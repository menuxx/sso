import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.App
import com.yingtaohuo.service.QiniuService
import com.yingtaohuo.util.parseQrcode
import com.yingtaohuo.wx3rd.QrCodeInfo
import com.yingtaohuo.wx3rd.WXAuthorizerCache
import com.yingtaohuo.wx3rd.WXLiteApi
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import java.io.ByteArrayInputStream
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(App::class))
@WebAppConfiguration
class QiniuServiceTest {

    @Autowired
    lateinit var qiniuService: QiniuService

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var wxAuthorizerCache: WXAuthorizerCache

    @Test
    fun uploadTest() {
        val appid = "wxef4ff9ec0c404e80" // 保亿四楼美食城
        val api = WXLiteApi(objectMapper)
        val accessToken = wxAuthorizerCache.getAuthorizerToken(appid)
        println(accessToken)
        if ( accessToken != null ) {
            val info = QrCodeInfo("/pages/index/index", 430)
            val resp = api.createWXQrcode(accessToken, info)
            if ( resp.isSuccessful ) {
                val body = resp.body()
                if (body != null) {
                    val fileKey = UUID.randomUUID().toString()
                    val bytes = body.bytes()
                    val stream1 = ByteArrayInputStream(bytes)
                    val stream2 = ByteArrayInputStream(bytes)
                    val url = parseQrcode(stream1)
                    println("url : $url")
                    qiniuService.uploadFile(stream2, "image/qrcode/$fileKey.jpg")
                }
            }
        }
    }

}