package ru.ubrr.p4_add_from_web;


/**
 * ������ ���������� ������� ����� � ������ ������ �������� ����� ��������.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}