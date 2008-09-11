package org.meta_environment.eclipse.actions;

import toolbus.adapter.eclipse.EclipseTool;

public class LanguageActionsTool extends EclipseTool {
	private static class InstanceKeeper{
		private static LanguageActionsTool sInstance = new LanguageActionsTool();
		static{
			sInstance.connect();
		}
	}
	
	private LanguageActionsTool() {
		super("language-actions");
	}
	
	public static LanguageActionsTool getInstance(){
		return InstanceKeeper.sInstance;
	}
	
	public void PerformAction (String Action, String language, String Filename) {
		this.sendEvent(factory.make("perform-action(<str>,<str>,<str>)", Action, language, Filename));
	}
	
}
