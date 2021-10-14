package ru.ubrr.p4_add_from_web;


/**
 * ���, ������������ �������, �� ������� � ����� ��������� �������� �� ��������.
 * ��� ���������� ��������� �������� � ���������� ����� ����������� ���������.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}