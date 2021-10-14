package ru.ubrr.p4_add_from_web;


/**
 * ����-�����. ����� �� �������� �������.
 */
public class Runner {

    /**
     * ���������� �������� ��� � ������ ���������� ������� ����������� ������
     * �� ������������ ��� ���������.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName);
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}