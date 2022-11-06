//
//  SearchView.swift
//  iosApp
//
//  Created by Никита on 06.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchView: View {
    
    let viewState: SearchViewState
    let eventHandler: (SearchEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 56)
                CommonTextField(hint: "Search Game") {newValue in
                    eventHandler(SearchEvent.QueryChanged(query: newValue))
                }
                Spacer().frame(height: 16)
                ScrollView{
                    VStack {
                        ForEach(viewState.game, id: \.gameId) { game in
                            VStack(alignment: .leading) {
                                Text(game.title)
                                    .foregroundColor(.textPrimary)
                                    .padding(EdgeInsets(top: 8, leading: 16, bottom: 8, trailing: 16))
                            }
                        }
                    }
                }
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.backgroundPrimary)
    }
}

//struct SearchView_Previews: PreviewProvider {
//    static var previews: some View {
//        SearchView()
//    }
//}
