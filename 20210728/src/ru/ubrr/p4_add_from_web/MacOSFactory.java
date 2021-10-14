package ru.ubrr.p4_add_from_web;


/**
 *  ажда€ конкретна€ фабрика знает и создаЄт только продукты своей вариации.
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