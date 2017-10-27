package com.yingtaohuo.util

import com.google.zxing.*
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeReader
import org.yaml.snakeyaml.reader.ReaderException
import java.util.*
import javax.imageio.ImageIO
import com.google.zxing.common.BitMatrix
import com.google.zxing.multi.qrcode.QRCodeMultiReader
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.sun.imageio.spi.FileImageInputStreamSpi
import com.yingtaohuo.exception.HttpException
import okhttp3.OkHttpClient
import okhttp3.Request
import java.awt.image.BufferedImage
import java.io.*
import javax.imageio.ImageReader
import javax.imageio.stream.FileImageInputStream
import javax.imageio.stream.ImageInputStream
import java.awt.image.Raster






/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */

@Throws(ReaderException::class)
fun parseQrcode(qrcodeImage: File) : String {
    val image = ImageIO.read(qrcodeImage)
    val subImage = image.getSubimage(0, 0, image.width, (image.height * 0.85).toInt())
    // val image = ImageIO.read(resp.body().byteStream())
    val source = BufferedImageLuminanceSource(subImage)
    val bitmap = BinaryBitmap(HybridBinarizer(source))
    //decode the barcode
    val qrreader = QRCodeReader()
    val hints = mutableMapOf<DecodeHintType, Any>()
    hints[DecodeHintType.PURE_BARCODE] = true
    hints[DecodeHintType.POSSIBLE_FORMATS] = listOf(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_128)
    hints[DecodeHintType.CHARACTER_SET] = "UTF-8"
    val result = qrreader.decode(bitmap, hints)
    return result.text
}

@Throws(HttpException::class)
fun getUrlImageToByteArray(httpClient: OkHttpClient, imageUrl: String) : ByteArray? {
    val request = Request.Builder().get().url(imageUrl).build()
    val resp = httpClient.newCall(request).execute()
    val body = resp.body()
    if ( resp.isSuccessful && body != null ) {
        return body.bytes()
    } else {
        throw HttpException(resp.message())
    }
}


private val BLACK = -0x1000000
private val WHITE = -0x1

/**
 * 最终调用该方法生成二维码图片
 * @param url 要生成二维码的url
 * @param imgPath 二维码生成的绝对路径
 * @param logoPath 二维码中间logo绝对地址
 * @throws Exception
 */
@Throws(Exception::class)
fun get2CodeImage(url: String, logoData: ByteArray) : ByteArrayOutputStream {
    val format = "png"
    val hints = Hashtable<EncodeHintType, Any>()
    hints.put(EncodeHintType.MARGIN, "2")
    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8")
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H)
    val bitMatrix = MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints)
    return writeToOutput(bitMatrix, format, logoData)
}

/**
 *
 * @param matrix 二维码矩阵相关
 * @param format 二维码图片格式
 * @param file 二维码图片文件
 * @param logoPath logo路径
 * @throws IOException
 */
@Throws(IOException::class)
fun writeToOutput(matrix: BitMatrix, format: String, logoData: ByteArray) : ByteArrayOutputStream {
    val image = toBufferedImage(matrix)
    val gs = image.createGraphics()
    //载入logo
    val img = ImageIO.read(ByteArrayInputStream(logoData))
    gs.drawImage(img, 150, 150, null)
    gs.dispose()
    img.flush()
    val output = ByteArrayOutputStream()
    if (!ImageIO.write(image, format, output)) {
        throw IOException("Could not write an image of format $format")
    }
    return output
}

fun toBufferedImage(matrix: BitMatrix): BufferedImage {
    val width = matrix.width
    val height = matrix.height
    val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    for (x in 0 until width) {
        for (y in 0 until height) {
            image.setRGB(x, y, if (matrix.get(x, y)) BLACK else WHITE)
        }
    }
    return image
}