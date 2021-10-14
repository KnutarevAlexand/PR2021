package ru.ubrr.p4_add_from_web;


/**
 *  ажда€ конкретна€ фабрика знает и создаЄт только продукты своей вариации.
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