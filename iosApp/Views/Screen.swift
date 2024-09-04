//
//  Screen.swift
//  iosApp
//
//  Created by Dhanesh Katre on 04/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct Screen: View {
    
    let canGoBack: Bool
    
    let viewModel: IScreenViewModel = IOSHelpers().provideScreenViewModel(
        coroutineScope: IOSHelpers().coroutineScope
    )
    
    let color = Color.random()
    
    var body: some View {
        
        ZStack {
            
            color.ignoresSafeArea()
            
            VStack {
                
                Spacer()
                
                Text("Screen with Color(\(color.toString()))")
                    .foregroundStyle(Color.black)
                    .font(.headline)
                    .frame(height: 55)
                    .frame(maxWidth: .infinity)
                    .background(Color.white)
                    .padding(16)
                
                Button {
                    viewModel.onEvent(screenEvent: ScreenEvent.LoadNewScreen())
                } label: {
                    Text("Launch next screen".uppercased())
                        .foregroundStyle(Color.white)
                        .font(.headline)
                        .frame(height: 55)
                        .frame(maxWidth: .infinity)
                        .background(Color.accentColor)
                        .clipShape(RoundedRectangle(cornerSize: CGSize(width: 10, height: 10)))
                        .padding(16)
                }
                
                Spacer()
            }
        }
    }
}

#Preview {
    Screen(canGoBack: true)
}
