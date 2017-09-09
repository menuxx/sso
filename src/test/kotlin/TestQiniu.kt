import com.qiniu.util.Auth
import com.yingtaohuo.util.getJwtSubject
import com.yingtaohuo.util.getTelPhoneFromToken
import com.yingtaohuo.util.isTokenExpired
import com.yingtaohuo.util.validateToken
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.xml.bind.DatatypeConverter
import javax.crypto.spec.SecretKeySpec



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
    val expirationDate = Date(Date().toInstant().plusSeconds(28800).toEpochMilli())

    val subject = "13593309412"
    val expireTime = expirationDate.time / 1000
    val audience = 32
    // val secret = "MTIzNA=="
    val secret = "hw3h9y"

    // val secretKey = DatatypeConverter.parseBase64Binary(secret)

    // val signingKey = SecretKeySpec(secretKey, SignatureAlgorithm.HS256.jcaName)

    val claims = mapOf("sub" to subject, "aud" to audience, "exp" to expireTime)

    val token = Jwts.builder()
    .setClaims(claims)
    .setSubject(subject)
    .setAudience(audience.toString())
    .setIssuedAt(createdDate)
    .setExpiration(expirationDate)
    .signWith(SignatureAlgorithm.HS512, secret)
    .compact()

    // println("------" + getJwtSubject(token))

    // println("secretKey: ${String(secretKey)}")

    println(token)
//
//    val header = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).header
//    println(header)
//
//    val body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
//
//    println(body)

    // val token1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU3NTc2MjgxNyIsImF1ZCI6IjciLCJleHAiOjE1MDQ5MTYwMzcsImlhdCI6MTUwNDg4NzIzN30.RTicBIopDZ_tdpXFkBQdxc4jmd84tBMdsH_jAWDLHteWVWNaqjoL89Y5K2vOMTeUMpcuM29ghyY8qatSg67TZw"

    // println("secretKey: $secretKey")

    // val secretKey1 = DatatypeConverter.parseBase64Binary(secret)
    val token1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU5MzMwOTQxMiIsImF1ZCI6IjciLCJleHAiOjE1MDQ5NTgxMDksImlhdCI6MTUwNDkyOTMwOX0.IlHTivBaH4tLLYDtXEHb9rAb0Uw6WklwGSqNUiwaWndea10XviJp-fulwNe0vLLOmcZOp15qzWgkGh1oetVcYQ"
    //val token1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU5MzMwOTQxMiIsImF1ZCI6IjciLCJleHAiOjE1MDQ5NTU1MDAsImlhdCI6MTUwNDkyNjcwMH0.22efzHQzGYJ16ObnBZ_sMON1iKLVOuUAiVh3QQLtbhH4RhvQ_o4XZ1h_DNfTOnsx6u2FvijaeugiRqPgIaPx_A"

    println(isTokenExpired(token1, secret))
    println(isTokenExpired(token1, secret))
    println(getTelPhoneFromToken(token, secret))

    println(
            Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token1)
            .body.subject
    )

}