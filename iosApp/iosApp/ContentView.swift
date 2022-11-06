import SwiftUI

struct ContentView: View {

	var body: some View {
//        Button {
//            viewModel.obtainEvent(viewEvent: .LoginClick())
//        } label: {
//            Text("Click Me")
//        }
        NavigationView {
            LoginScreen()
                .background(Color.backgroundPrimary)
                .background(ignoresSafeAreaEdges: [.top, .bottom, .leading, .trailing])
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
