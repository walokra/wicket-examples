package com.ruleoftech.wicket.example.uniqfeedback.feedback;

import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * FeedbackPanel with UniqueMessageFilter which filters duplicate messages.
 * 
 * @author wallinmr
 * 
 */
@SuppressWarnings("serial")
public class UniqueMessagesFeedbackPanel extends FeedbackPanel {
	private final UniqueMessageFilter filter = new UniqueMessageFilter();

	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();
		// clear old messages
		filter.clearMessages();
	}

	public UniqueMessagesFeedbackPanel(String id) {
		super(id);
		setFilter(filter);
	}
}
