//
//  ActionButton.swift
//  iosApp
//
//  Created by Никита on 05.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ActionButton: View {
    
    let title: String
    var enabled: Bool
    let height: CGFloat
    let horizonalMargin: CGFloat = 16
    let action: () -> Void
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tintColor)
                .opacity(enabled ? 1.0 : 0.5)
            Text(title)
                .foregroundColor(.textAction)
        }
        .frame(maxWidth: .infinity, minHeight: height)
        .padding(EdgeInsets(top: 0, leading: horizonalMargin, bottom: 0, trailing: horizonalMargin))
        .onTapGesture {
            action()
        }
    }
}

//struct ActionButton_Previews: PreviewProvider {
//    static var previews: some View {
//        ActionButton()
//    }
//}
