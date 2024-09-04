//
//  AppContent.swift
//  iosApp
//
//  Created by Dhanesh Katre on 04/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct AppContent: View {
    
    @ObservedObject
    var navigator: AppNavigator = AppNavigator()
    
    @State
    var isSnackbarVisible: Bool = false
    
    @StateObject
    var adapter = KotlinViewAdapter<ISnackbarHelper, SnackbarEvent>(
        initialValue: SnackbarEvent(message: "", action: nil),
        createViewModel: { _ in
            IOSHelpers().snackbarHelper
        },
        getState: { $0.events }
    )
    
    var body: some View {
        
        ZStack {
            
            NavigationStack(path: $navigator.path) {
                Screen(canGoBack: navigator.canGoBack())
                    .navigationDestination(for: String.self) { route in
                        
                        if route == Constants.NavigationRoutes().SCREEN {
                            Screen(canGoBack: navigator.canGoBack())
                        }
                        
                        if route == Constants.NavigationRoutes().SCREEN_404 {
                            Screen404()
                        }
                    }
            }
            
            if isSnackbarVisible {
                
                let event = adapter.state
                
                if !event.message.isEmpty || event.action != nil {
                    SnackbarView(
                        event: event,
                        isVisible: $isSnackbarVisible
                    )
                    .onAppear {
                        DispatchQueue.main.asyncAfter(deadline: .now() + 4.0) {
                            isSnackbarVisible = false
                        }
                    }
                }
            }
        }.onAppear {
            adapter.setOnEachAction { event in
                self.isSnackbarVisible = false
                self.isSnackbarVisible = true
            }
        }
    }
}

#Preview {
    AppContent()
}
