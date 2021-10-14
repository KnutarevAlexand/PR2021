package ru.ubrr.p4_add_from_web;


/**
 * ������ ���������� ������� ����� � ������ ������ �������� ����� ��������.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}