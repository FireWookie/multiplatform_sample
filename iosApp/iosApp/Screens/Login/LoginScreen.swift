//
//  LoginScreen.swift
//  iosApp
//
//  Created by Никита on 05.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginScreen: View {
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainPresented = false
    
    private let loginViewModel = LoginViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(loginViewModel.viewStates())) { viewState in
            LoginView(loginViewModel: loginViewModel, viewState: viewState) { event in
                loginViewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isRegistrationPresented, content: {
            RegistrationScreen()
        })
        .sheet(isPresented: $isForgotPresented, content: {
            ForgotScreen()
        })
        .fullScreenCover(isPresented: $isMainPresented, content: {
            MainView()
        })
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
    }
}
