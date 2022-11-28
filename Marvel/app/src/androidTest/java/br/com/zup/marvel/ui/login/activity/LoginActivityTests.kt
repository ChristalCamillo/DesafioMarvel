package br.com.zup.marvel.ui.login.activity

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import br.com.zup.marvel.EMAIL_ERROR_MESSAGE
import br.com.zup.marvel.PASSWORD_ERROR_MESSAGE
import br.com.zup.marvel.ui.login.view.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import br.com.zup.marvel.R.id.btnLogin
import br.com.zup.marvel.R.id.etEmailLogin
import br.com.zup.marvel.R.id.etPasswordLogin



@RunWith(JUnit4::class)
@LargeTest
class LoginActivityTests {

    @get:Rule
    var rule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun showSnackBarError_whenEmailIsEmpty(){
        onView(withId(btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(EMAIL_ERROR_MESSAGE)))
    }

    @Test
    fun showSnackBarError_whenPasswordIsEmpty(){
        onView(withId(btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(PASSWORD_ERROR_MESSAGE)))
    }

    @Test
    fun showSnackBarError_whenOnlyPasswordIsEmpty(){
        onView(withId(etEmailLogin)).perform(typeText("hdsdjhgjwh"))
        closeSoftKeyboard()
        onView(withId(btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(PASSWORD_ERROR_MESSAGE)))
    }

    @Test
    fun showSnackBarError_whenOnlyEmailIsEmpty(){
        onView(withId(etPasswordLogin)).perform(typeText("12345678"))
        closeSoftKeyboard()
        onView(withId(btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(EMAIL_ERROR_MESSAGE)))
    }
}