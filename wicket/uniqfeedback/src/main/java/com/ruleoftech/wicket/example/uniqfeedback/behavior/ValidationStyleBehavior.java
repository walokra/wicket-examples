package com.ruleoftech.wicket.example.uniqfeedback.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.FormComponentLabel;
import org.apache.wicket.markup.html.form.LabeledWebMarkupContainer;

/**
 * ValidationStyleBehavior add CSS class "invalid" to component if there is a
 * validation error.
 * */
@SuppressWarnings("serial")
public class ValidationStyleBehavior extends Behavior {

	@Override
	@SuppressWarnings("rawtypes")
	public void onComponentTag(final Component component, final ComponentTag tag) {
		String errorStyleClass = "invalid";

		if (component instanceof FormComponentLabel) {
			FormComponentLabel labelComp = (FormComponentLabel) component;
			LabeledWebMarkupContainer lwmcon = labelComp.getFormComponent();

			if (lwmcon instanceof FormComponent && !((FormComponent) lwmcon).isValid()) {
				tag.append("class", errorStyleClass, " ");
			}
			return;
		}

		if (component instanceof FormComponent && !((FormComponent) component).isValid()) {
			tag.append("class", errorStyleClass, " ");
		}
	}
};
