package com.ruleoftech.wicket.example.uniqfeedback.feedback;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;

/**
 * FeedbackMessageFilter which filters duplicate FeedbackMessages.
 * 
 * @author wallinmr
 * 
 */
@SuppressWarnings("serial")
public class UniqueMessageFilter implements IFeedbackMessageFilter {
	List<FeedbackMessage> messages = new ArrayList<FeedbackMessage>();

	public void clearMessages() {
		messages.clear();
	}

	@Override
	public boolean accept(FeedbackMessage currentMessage) {
		for (FeedbackMessage message : messages) {
			if (message.getMessage().toString().equals(currentMessage.getMessage().toString())) {
				return false;
			}
		}
		messages.add(currentMessage);
		return true;
	}
}
