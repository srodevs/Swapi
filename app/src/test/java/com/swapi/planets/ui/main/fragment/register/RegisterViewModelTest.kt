package com.swapi.planets.ui.main.fragment.register

import com.swapi.planets.core.SharedPrefs
import com.swapi.planets.domain.user.CreateNewUserUseCase
import com.swapi.planets.ui.model.UserModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {
    @MockK
    private lateinit var createNewUserUseCase: CreateNewUserUseCase

    @MockK
    private lateinit var sharedPrefs: SharedPrefs

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        // Arrange
        coEvery { createNewUserUseCase.invoke(any()) } returns Unit
        every { sharedPrefs.setValueLogin(any()) } returns Unit

        viewModel = RegisterViewModel(createNewUserUseCase, sharedPrefs)
    }

    @Test
    fun `insertUser - should call useCase, set login true, and return success`() = runTest {
        // Arrange
        val user = UserModel("1", "Rodrigo", "", "", "")
        var callbackResult: Boolean? = null

        // Act
        viewModel.insertUser(user) {
            callbackResult = it
        }

        // Assert
        coVerify(exactly = 1) { createNewUserUseCase.invoke(user) }
        verify(exactly = 1) { sharedPrefs.setValueLogin(true) }

        assertTrue(callbackResult == true)
    }

}