package com.example.test.form;

import com.example.test.model.Counter;
import com.example.test.service.CounterService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.stereotype.Component;

@Component
public class CounterForm extends FormLayout {
    private final CounterService counterService;
    Counter counter = new Counter(0);


    IntegerField valueInput =
            new IntegerField("Value");

    public CounterForm(CounterService counterService) {
        this.counterService = counterService;
        Binder<Counter> binder =
                new Binder<>(Counter.class);
        binder.bind(valueInput, Counter::getValue, Counter::setValue);
        add(valueInput);
        Button incrementButton = new Button("Ещё",
                event -> {
                    counter.setValue(counter.getValue() + 1);
                    binder.readBean(counter);
                    counterService.save(counter);
                });
        add(incrementButton);



    }
}
