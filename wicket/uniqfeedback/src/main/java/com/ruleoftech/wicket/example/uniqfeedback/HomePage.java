package com.ruleoftech.wicket.example.uniqfeedback;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponentLabel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ruleoftech.wicket.example.uniqfeedback.behavior.ValidationStyleBehavior;
import com.ruleoftech.wicket.example.uniqfeedback.feedback.UniqueMessagesFeedbackPanel;

/**
 * Simple page with some input fields for testing filtering duplicate FeedbackMessages.
 * 
 * @author wallinmr
 * 
 */
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		super(parameters);

		final FeedbackPanel feedbackPanel = new UniqueMessagesFeedbackPanel("status");
		add(feedbackPanel.setOutputMarkupId(true));

		final Form<Void> form = new Form<Void>("form");

		// Bind a TextField to the input element
		TextField<String> valueField = new TextField<String>("value");
		valueField.setRequired(true);
		valueField.setOutputMarkupId(true);
		// This could equally pull a label out of a resource.
		valueField.setLabel(new Model<String>("Value *"));
		// Bind a FormComponentLabel component to the label element: This will automatically update the "for" attribute
		// to match the id of somethingField
		FormComponentLabel valueLabel = new FormComponentLabel(valueField.getId() + "Label", valueField);
		// Add the field to the containing label.
		valueLabel.add(valueField);
		Label valueFieldLabelText = new Label(valueLabel.getId() + "Text", valueField.getLabel());
		// Get rid of the span tag, leaving the label only
		valueFieldLabelText.setRenderBodyOnly(true);
		// Add the label span to the containing label
		valueLabel.add(valueFieldLabelText);
		valueLabel.add(new ValidationStyleBehavior());
		// Finally, add the containing label to the form
		form.add(valueLabel);

		// Description
		TextField<String> descField = new TextField<String>("desc");
		descField.setRequired(true);
		descField.setOutputMarkupId(true);
		descField.setLabel(new Model<String>("Description *"));
		FormComponentLabel descLabel = new FormComponentLabel(descField.getId() + "Label", descField);
		descLabel.add(descField);
		Label descFieldLabelText = new Label(descLabel.getId() + "Text", descField.getLabel());
		descFieldLabelText.setRenderBodyOnly(true);
		descLabel.add(descFieldLabelText);
		descLabel.add(new ValidationStyleBehavior());
		form.add(descLabel);

		// startDate
		TextField<String> startDateField = new TextField<String>("startDate");
		startDateField.setRequired(true);
		startDateField.setOutputMarkupId(true);
		startDateField.setLabel(new Model<String>("Start date *"));
		FormComponentLabel startDateLabel = new FormComponentLabel(startDateField.getId() + "Label", startDateField);
		startDateLabel.add(startDateField);
		Label startDateFieldLabelText = new Label(startDateLabel.getId() + "Text", startDateField.getLabel());
		startDateFieldLabelText.setRenderBodyOnly(true);
		startDateLabel.add(startDateFieldLabelText);
		startDateLabel.add(new ValidationStyleBehavior());
		form.add(startDateLabel);

		// endDate
		TextField<String> endDateField = new TextField<String>("endDate");
		endDateField.setRequired(true);
		endDateField.setOutputMarkupId(true);
		endDateField.setLabel(new Model<String>("End date *"));
		FormComponentLabel endDateLabel = new FormComponentLabel(endDateField.getId() + "Label", endDateField);
		endDateLabel.add(endDateField);
		Label endDateFieldLabelText = new Label(endDateLabel.getId() + "Text", endDateField.getLabel());
		endDateFieldLabelText.setRenderBodyOnly(true);
		endDateLabel.add(endDateFieldLabelText);
		endDateLabel.add(new ValidationStyleBehavior());
		form.add(endDateLabel);

		Button saveButton = new Button("saveButton") {
			@Override
			public void onSubmit() {
				info("Successfull!");
			}
		};
		form.add(saveButton);

		// Reset form's fields
		Button resetButton = new Button("resetButton") {
			@Override
			public void onSubmit() {
				form.clearInput();
				// form.setModel(new Model());
			}
		};
		resetButton.setDefaultFormProcessing(false);
		form.add(resetButton);

		add(form);
	}
}
