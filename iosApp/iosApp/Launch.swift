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
    let root: RootComponent = RootComponentImpl(componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle()))

    func application(
            _ application: UIApplication,
            didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
    ) -> Bool {
        return true
    }

}

struct ComposeView: UIViewControllerRepresentable {
    private var component: RootComponent
    
    init(_ component: RootComponent) {
        self.component = component
    }

    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController(component: component)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
