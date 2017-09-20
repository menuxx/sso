import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.lang.ClassCastException
import java.util.*
import java.util.regex.Pattern
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaType


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/25
 * 微信: yin80871901
 */

fun toUnderscore(s: String) : String {
    val m = Pattern.compile("(?<=[a-z])[A-Z]").matcher(s)
    val sb = StringBuffer()
    while (m.find()) {
        m.appendReplacement(sb, "_" + m.group().toLowerCase())
    }
    m.appendTail(sb)
    return sb.toString()
}

inline fun <reified T : Any> mapToBean(map: Map<String, Any>) : T {
    val instan = T::class.createInstance()
    val properties = T::class.declaredMemberProperties.filterIsInstance<KMutableProperty<*>>()
    for (p in properties) {
        val rawVal =  map[toUnderscore(p.name)]
        if (rawVal != null) {
            val typedVal = when(p.getter.call(instan)) {
                is String -> rawVal
                is Int -> rawVal.toString().toIntOrNull()
                is Boolean -> rawVal.toString().toBoolean()
                is Long -> rawVal.toString().toLongOrNull()
                is Double -> rawVal.toString().toDoubleOrNull()
                else -> throw IllegalArgumentException("未知参数类型，转换值只能支持原始类型")
            }
            p.setter.call(instan, typedVal)
        }
    }
    return instan
}

data class Order1(var id: Int?, var name: String?, var age: String?, var nickName: String?) {
    constructor() : this(0, "0", "0", "")
}

data class Order(var id: Int, var name: String, var age: String)

fun main(args: Array<String>) {

    /*
    val accessKey = "sr4H3rnxg3fkN9bf5NBTj9V9ptPFMnW5Ryxbg_o6"
    val secretKey = "9Gtvk0QbjvLDKWXwAi_WCYQkLq5Biu-X9wjHjXS5"
    val auth = Auth.create(accessKey, secretKey)
    println(auth.uploadToken("dz-cdn1"))
    */

    val createdDate = Date()
    val expirationDate = Date(Date().toInstant().plusSeconds(28800).toEpochMilli())

    val subject = "13575762817"
    val expireTime = expirationDate.time / 1000
    val audience = 7
    // val secret = "MTIzNA=="
    val secret = "eWluZ3Rhb2h1bw=="

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
    // val token1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU5MzMwOTQxMiIsImF1ZCI6IjMyIiwiZXhwIjoxNTA0OTYxNzAxLCJpYXQiOjE1MDQ5MzI5MDF9.g7itROrtd8v_uJYBMg1fXIEdYTJRQM-m3WCYxzf9MMX9rpMEyXheOo3O_W5IY2OZNK5-LfynxYRZkpDJ8aoxSg"
    //val token1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzU5MzMwOTQxMiIsImF1ZCI6IjciLCJleHAiOjE1MDQ5NTU1MDAsImlhdCI6MTUwNDkyNjcwMH0.22efzHQzGYJ16ObnBZ_sMON1iKLVOuUAiVh3QQLtbhH4RhvQ_o4XZ1h_DNfTOnsx6u2FvijaeugiRqPgIaPx_A"

//    println(isTokenExpired(token1, secret))
//    println(isTokenExpired(token1, secret))
//    println(getTelPhoneFromToken(token, secret))
//
//    println(
//            Jwts.parser()
//            .setSigningKey(secret)
//            .parseClaimsJws(token1)
//            .body.subject
//    )


    println(mapToBean<Order1>(mapOf("id" to "1", "name" to "lisi", "age" to "111", "nick_name" to "张三")))

}