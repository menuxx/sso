package com.yingtaohuo.db

import com.yingtaohuo.util.camelToUnderscore
import org.jooq.Record
import org.springframework.beans.BeanUtils
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/2
 * 微信: yin80871901
 */
inline fun <reified R: Record, reified M> toRecord(model: M, change: Boolean) : R {

    val rCtor = R::class.java
    val mCtor = M::class.java

    val emptyRecord = rCtor.newInstance()

    // 获取 关于 model 所有 getXX 的方法
    val mGetters = mCtor.declaredMethods
            .filter { m -> Modifier.PUBLIC == m.modifiers && m.name.startsWith("get") && m.name[3].isUpperCase() }
            .map { m -> camelToUnderscore(m.name.substring(3)) to m } .toMap()

    // 获取所有 所有 record 的 setXX 方法
    val mSetters = rCtor.declaredMethods
            .filter { m -> Modifier.PUBLIC == m.modifiers && m.name.startsWith("set") && m.name[3].isUpperCase() }
            .map { m -> camelToUnderscore(m.name.substring(3)) to m } .toMap()

    // 将所有 change 设置成 false
    if (change) mSetters.forEach { name, _ -> emptyRecord.changed(name, false) }

    // 将所有 model 的值存储到 record 中，并将 change 改成 true
    mGetters.forEach { (name, getter) ->
        val mSetter = mSetters[name]
        if (mSetter != null) {
            try {
                val _value = getter.invoke(model)
                if ( _value != null ) {
                    mSetter.invoke(emptyRecord, _value)
                    if (change) emptyRecord.changed(name, true)
                } else {
                    // 如果未设置值，就将 change 改成 false
                    if (change) emptyRecord.changed(name, false)
                }
            } catch (ex: InvocationTargetException) {
                ex.printStackTrace()
            } catch (ex: IllegalArgumentException) {
                ex.printStackTrace()
            } catch (ex: IllegalAccessException) {
                ex.printStackTrace()
            }
        }
    }

    return emptyRecord

}

inline fun <reified R: Record, reified M> fromRecord(record: R) : M {
    val mCtor = M::class.java
    val mode = mCtor.newInstance()
    BeanUtils.copyProperties(record, mode)
    return mode
}