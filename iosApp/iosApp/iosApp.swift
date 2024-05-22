import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate

    init() {

        KoinInjector.shared.koinApp
    }

    var body: some Scene {

        WindowGroup {
            ComposeView(
                appDelegate.root,
                backDispatcher: appDelegate.backDispatcher
            ).ignoresSafeArea(.all)
        }
    }
}
