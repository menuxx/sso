import com.qiniu.util.Auth
import com.yingtaohuo.util.getJwtSubject
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/25
 * 微信: yin80871901
 */


fun main(args: Array<String>) {

    /*
    val accessKey = "sr4H3rnxg3fkN9bf5NBTj9V9ptPFMnW5Ryxbg_o6"
    val secretKey = "9Gtvk0QbjvLDKWXwAi_WCYQkLq5Biu-X9wjHjXS5"
    val auth = Auth.create(accessKey, secretKey)
    println(auth.uploadToken("dz-cdn1"))
    */

    val createdDate = Date()
    val expirationDate = Date(Date().toInstant().plusSeconds(7200).toEpochMilli())

    val subject = "13575762817"
    val expireTime = expirationDate.time / 1000
    val audience = 7
    val secret = "1234"

    val claims = mapOf("sub" to subject, "aud" to audience, "exp" to expireTime)

    val token = Jwts.builder()
    .setClaims(claims)
    .setSubject(subject)
    .setAudience(audience.toString())
    .setIssuedAt(createdDate)
    .setExpiration(expirationDate)
    .signWith(SignatureAlgorithm.HS512, secret)
    .compact()

    println("------" + getJwtSubject(token))

    println(token)

    val header = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).header
    println(header)

    val body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body

    println(body)

}