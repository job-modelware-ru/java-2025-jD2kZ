//Product 
interface Button {
    void render();
}

//ConcreteProductA 
class TextButton implements Button {
    @Override
    public void render() {
        System.out.println("button with text");
    }
}

//ConcreteProductB 
class ImageButton implements Button {
    @Override
    public void render() {
        System.out.println("button with image");
    }
}

//ConcreteProductC 
class DropdownButton implements Button {
    @Override
    public void render() {
        System.out.println("button with dropdown");
    }
}

//Creator
abstract class LoginWindow {
    public abstract Button createButton();

    public void open() {
        System.out.println("login window");
        Button button = createButton();
        button.render();
    }
}

//ConcreteCreatorA 
class TextLoginWindow extends LoginWindow {
    @Override
    public Button createButton() {
        return new TextButton(); 
    }
}

//ConcreteCreatorB
class ImageLoginWindow extends LoginWindow {
    @Override
    public Button createButton() {
        return new ImageButton(); 
    }
}

//ConcreteCreatorC
class DropdownLoginWindow extends LoginWindow {
    @Override
    public Button createButton() {
        return new DropdownButton(); 
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println("text-based login window");
        LoginWindow window = new TextLoginWindow(); 
        window.open(); 
    }
}