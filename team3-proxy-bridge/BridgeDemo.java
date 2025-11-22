// 1. Implementor
interface WindowImp {
    void DevDrawText(String text);
    void DevDrawLine(int x1, int y1, int x2, int y2);
    void DevDrawBitmap(String bitmap, int x, int y);
}

// 2. ConcreteImplementor
class XWindowImp implements WindowImp {
    public void DevDrawText(String text) {}
    public void DevDrawLine(int x1, int y1, int x2, int y2) {}
    public void DevDrawBitmap(String bitmap, int x, int y) {}
}

// 3. ConcreteImplementor
class WindowsWindowImp implements WindowImp {
    public void DevDrawText(String text) {}
    public void DevDrawLine(int x1, int y1, int x2, int y2) {}
    public void DevDrawBitmap(String bitmap, int x, int y) {}
}

// 4. Abstraction
abstract class Window {
    protected WindowImp imp;
    public Window(WindowImp imp) {
        this.imp = imp;
    }
    public abstract void drawContents();
    public abstract void drawRect(int x1, int y1, int x2, int y2);
    // Базовые операции, которые могут использовать все окна
    public void drawText(String text) {
        imp.DevDrawText(text);
    }
    public void drawBitmap(String bitmap, int x, int y) {
        imp.DevDrawBitmap(bitmap, x, y);
    }
}

// 5. RefinedAbstraction
class IconWindow extends Window {
    private String bitmapName;
    public IconWindow(WindowImp imp, String bitmapName) {
        super(imp);
        this.bitmapName = bitmapName;
    }
    public void drawContents() {
        // Отрисовка иконки используя базовые операции
        drawBitmap(bitmapName, 0, 0);
    }
    public void drawRect(int x1, int y1, int x2, int y2) {
        // Отрисовка прямоугольника средствами реализации
        imp.DevDrawLine(x1, y1, x2, y1);
        imp.DevDrawLine(x2, y1, x2, y2);
        imp.DevDrawLine(x2, y2, x1, y2);
        imp.DevDrawLine(x1, y2, x1, y1);
    }
}

// 6. Другая RefinedAbstraction
class TransientWindow extends Window {
    public TransientWindow(WindowImp imp) {
        super(imp);
    }
    public void drawContents() {} // Отрисовка временного окна
    public void drawRect(int x1, int y1, int x2, int y2) {} // Специфичная отрисовка рамки для временного окна
    public void drawCloseButton() {
        // Отрисовка кнопки закрытия используя базовые операции
        drawBitmap("close_icon", 10, 10);
    }
}

// Клиентский код
public class BridgeDemo {
    public static void main(String[] args) {
        // Создание абстракции с конкретной реализацией
        WindowImp imp = new XWindowImp();
        Window window = new IconWindow(imp, "icon.xpm");

        // Использование абстракции
        window.drawContents();
        window.drawRect(0, 0, 100, 100);

        // Легкая замена реализации
        WindowImp anotherImp = new WindowsWindowImp();
        Window anotherWindow = new TransientWindow(anotherImp);
        anotherWindow.drawContents();
    }
}