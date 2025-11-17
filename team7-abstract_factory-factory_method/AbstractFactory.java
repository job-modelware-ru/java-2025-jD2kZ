// ProductA
interface Button {
    void render();
}

// ConcreteProductA1
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }
}

// ConcreteProductA2
class LinuxButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Linux button");
    }
}

// ProductB
interface TextField {
    void render();
}

// ConcreteProductB1
class WindowsTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Windows text field");
    }
}

// ConcreteProductB2
class LinuxTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Linux text field");
    }
}

// Creator
interface UIFactory {
    Button createButton();
    TextField createTextField();
}

// ConcreteCreator for Windows
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        System.out.println("Creating Windows button");
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("Creating Windows text field");
        return new WindowsTextField();
    }
}

// ConcreteCreator for Linux
class LinuxUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        System.out.println("Creating Linux button");
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("Creating Linux text field");
        return new LinuxTextField();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        UIFactory factory;
        if (osName.contains("win")) {
            factory = new WindowsUIFactory();
        } else if (osName.contains("linux")) {
            factory = new LinuxUIFactory();
        } else {
            throw new IllegalArgumentException("Unsupported OS: " + osName);
        }
        System.out.println("Detected OS: " + osName + "\n");
        
        Button but = factory.createButton();
        TextField txt = factory.createTextField();

        System.out.println("\nRendering Button");
        but.render();

        System.out.println("\nRendering TextField");
        txt.render();
    }
}
