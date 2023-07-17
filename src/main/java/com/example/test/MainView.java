package com.example.test;

import com.example.test.form.CounterForm;
import com.example.test.service.CounterService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {
    private final CounterService counterService;

    CounterForm counterForm;

    public MainView(CounterService counterService) {
        this.counterService = counterService;
        configureForm();
        add(counterForm);
    }

    private void configureForm() {
        counterForm = new CounterForm(counterService);
    }

}
