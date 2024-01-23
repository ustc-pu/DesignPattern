public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory windowsXPFactory = new WindowsXPFactory();
        Window windowsXPWindow = windowsXPFactory.createWindow();
        Button windowsXPButton = windowsXPFactory.createButton();
        windowsXPWindow.display();
        windowsXPButton.click();


        GUIFactory windows10Factory = new Windows10Factory();
        Window windows10Window = windows10Factory.createWindow();
        Button windows10Button = windows10Factory.createButton();
        windows10Window.display();
        windows10Button.click();
    }
}

// Similar to FactoryPattern, interface of object
// But here usually it has a family of related objects, in FactoryPattern only 1 object.
interface Window {
    void display();
}

class WindowsXPWindow implements Window{
    @Override
    public void display() {
        System.out.println("This is a WindowsXP window");
    }
}

class Windows10Window implements Window {
    @Override
    public void display() {
        System.out.println("This is a Windows10 window");
    }
}

interface Button {
    void click();
}

class WindowsXPButton implements Button{
    @Override
    public void click() {
        System.out.println("Click WindowsXP button");
    }
}

class Windows10Button implements Button {
    @Override
    public void click() {
        System.out.println("Click Windows10 button");
    }
}

interface GUIFactory {
    Window createWindow();
    Button createButton();
}

class WindowsXPFactory implements GUIFactory {
    @Override
    public Window createWindow() {
        return new WindowsXPWindow();
    }

    @Override
    public Button createButton() {
        return new WindowsXPButton();
    }
}

class Windows10Factory implements GUIFactory {
    @Override
    public Window createWindow() {
        return new Windows10Window();
    }

    @Override
    public Button createButton() {
        return new Windows10Button();
    }
}