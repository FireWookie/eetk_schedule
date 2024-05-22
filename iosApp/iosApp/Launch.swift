//
//  Launch.swift
//  iosApp
//
//  Created by Никита on 20.05.2024.
//

import Foundation
import UIKit
import SwiftUI
import ComposeApp


class AppDelegate: NSObject, UIApplicationDelegate {
    var backDispatcher: BackDispatcher = BackDispatcherKt.BackDispatcher()

    lazy var root: RootComponent = RootComponentImpl(
        componentContext: DefaultComponentContext(
            lifecycle: ApplicationLifecycle(),
            stateKeeper: nil,
            instanceKeeper: nil,
            backHandler: backDispatcher
        )
    )

    func application(
            _ application: UIApplication,
            didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
    ) -> Bool {
        return true
    }

}

struct ComposeView: UIViewControllerRepresentable {
    private var component: RootComponent
    private var backDispatcher: BackDispatcher
    
    init(_ component: RootComponent, backDispatcher: BackDispatcher) {
        self.component = component
        self.backDispatcher = backDispatcher
    }

    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController(component: component, backDispatcher: self.backDispatcher)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
