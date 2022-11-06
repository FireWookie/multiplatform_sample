//
//  LoginView.swift
//  iosApp
//
//  Created by Никита on 05.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {
    
    var loginViewModel: LoginViewModel = LoginViewModel()
    let viewState: LoginViewState
    let eventHandler: (LoginEvent) -> Void
    
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainPresented = false
    
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Login Now")
                    .foregroundColor(Color.textPrimary)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                Text("Welocome to playzone")
                    .foregroundColor(.textPrimary.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
                Spacer().frame(height: 50)
                CommonTextField(hint: "Login", enabled: !viewState.isSending) { newValue in
                    eventHandler(.EmailChanged(value: newValue))
                }
                
                Spacer().frame(height: 24)
                CommonTextField(hint: "Password", enabled: !viewState.isSending, isSecure: !viewState.passwordHidden) { newValue in
                    eventHandler(.PasswordChanged(value: newValue))
                }
                LoginActionView(viewState: viewState) {
                    eventHandler(.ForgotClick())
                } onSubmitClicked: {
                    eventHandler(.LoginClick())
                }
                NavigationLink(isActive: $isRegistrationPresented, destination: {
                    RegistrationScreen()
                }, label: {
                    EmptyView()
                })
                
            }
            Spacer()
            HStack {
                Text("Dont have account?")
                    .foregroundColor(.textPrimary)
                    .opacity(0.5)
                Text("Create one")
                    .foregroundColor(.tintColor)
                    .fontWeight(.bold)
                    .onTapGesture {
                        eventHandler(.RegistrationClick())
                    }
            }
        }
        .onReceive(sharePublisher(loginViewModel.viewActions())) { action in
            switch (action) {
            case LoginAction.OpenForgotPassword():
                isForgotPresented = true
            case LoginAction.OpenRegistration():
                isRegistrationPresented = true
                print("registration open")
            case LoginAction.OpenMainFlow():
                isMainPresented = true
            default: break
            }
        }
        .navigationBarHidden(true)
        .navigationBarBackButtonHidden(true)
    }
}

struct LoginActionView: View {
    
    let viewState: LoginViewState
    let onForgotClicked: () -> Void
    let onSubmitClicked: () -> Void
    
    var body: some View {
        VStack {
            Spacer().frame(height: 30)
            HStack {
                Spacer()
                Text("Forgot Password")
                    .foregroundColor(.tintColor)
                    .onTapGesture {
                        onForgotClicked()
                    }
                Spacer().frame(width: 30)
            }
            Spacer().frame(height: 30)
            ActionButton(title: "Login Now", enabled: !viewState.isSending, height: 20) {
                onSubmitClicked()
            }
            .frame(height: 56)
            Spacer()
            
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView(
            viewState: LoginViewState(email: "asdasd", password: "asdasd", isSending: false, passwordHidden: false), eventHandler: { _ in
                
            }
        )
            .background(Color.backgroundPrimary)
            .background(ignoresSafeAreaEdges: [.top, .bottom])
    }
}
