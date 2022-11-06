//
//  LoginVM.swift
//  iosApp
//
//  Created by Никита on 05.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SharedSDK


class LoginVM: LoginViewModel, ObservableObject {
    @Published var state: LoginViewState
        
    override init() {
        self.state = LoginViewState(email: "", password: "", isSending: false, passwordHidden: false)
        
        super.init()
        
        viewStates().watch { [weak self] viewState in
            self?.state = viewState
        }
//            collect(flow: uiState, collect: { state in
//                self.state = state as! LoadScooterContractState
//            })
    }
}
