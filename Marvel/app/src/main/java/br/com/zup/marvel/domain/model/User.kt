package br.com.zup.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.junit.Ignore

@Parcelize
data class User(
    var name: String = "",
    var email: String = "",
    var password: String = ""
): Parcelable
