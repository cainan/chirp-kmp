package com.cso.auth.presentation.di

import com.cso.auth.presentation.email_verification.EmailVerificationViewModel
import com.cso.auth.presentation.forgot_password.ForgotPasswordViewModel
import com.cso.auth.presentation.login.LoginViewModel
import com.cso.auth.presentation.register.RegisterViewModel
import com.cso.auth.presentation.register_success.RegisterSuccessViewModel
import com.cso.auth.presentation.reset_password.ResetPasswordViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::ResetPasswordViewModel)
}