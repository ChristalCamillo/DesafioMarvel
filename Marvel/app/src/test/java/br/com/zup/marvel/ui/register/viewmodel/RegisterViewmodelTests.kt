package br.com.zup.marvel.ui.register.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.zup.marvel.*
import br.com.zup.marvel.domain.model.User
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest= Config.NONE)
class RegisterViewModelTests {

    @Test
    fun `empty name should alter error state value and be equal to name error message`() {
        val viewModel = RegisterViewModel()
        viewModel.validateDataUser(user = User(name = ""))
        viewModel.errorState.value.shouldBeEqualTo(NAME_ERROR_MESSAGE)
    }

    @Test
    fun `empty email should alter error state value and be equal to email error message`() {
        val viewModel = RegisterViewModel()
        viewModel.validateDataUser(user = User(name = "christal", email = ""))
        viewModel.errorState.value.shouldBeEqualTo(EMAIL_ERROR_MESSAGE)
    }

    @Test
    fun `empty password should alter error state value and be equal to password error message`() {
        val viewModel = RegisterViewModel()
        viewModel.validateDataUser(
            user = User(
                name = "christal",
                email = "christal.camillo@zup.com.br",
                password = ""
            )
        )
        viewModel.errorState.value.shouldBeEqualTo(PASSWORD_ERROR_MESSAGE)
    }

    @Test
    fun `name less than three characters should alter error state value and be equal to error validate name message`() {
        val viewModel = RegisterViewModel()
        viewModel.validateDataUser(user = User(name = "c", email = "christal.camillo@gmail.com", password = "1"))
        viewModel.errorState.value.shouldBeEqualTo(ERROR_VALIDATE_NAME)
    }

    @Test
    fun `password less than eight characters should alter error state value and be equal to error validate password`() {
        val viewModel = RegisterViewModel()
        viewModel.validateDataUser(
            user = User(
                name = "chiehfdioeh",
                email = "christal.camillo@zup.com.br",
                password = "1234567"
            )
        )
        viewModel.errorState.value.shouldBeEqualTo(ERROR_VALIDATE_PASSWORD)
    }

    @Test
    fun `when all fields are correct should return true creating a registered user`() {
        val viewModel = RegisterViewModel()
        val user = User(
            name = "christal",
            email = "christal.b.camillo@gmail.com",
            password = "12345678"
        )
        viewModel.validateDataUser(user).shouldBeTrue()
    }
}