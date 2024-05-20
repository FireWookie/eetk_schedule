import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    var body: some Scene {
        WindowGroup {
            ComposeView(appDelegate.root).ignoresSafeArea(.all)
        }
    }
}
