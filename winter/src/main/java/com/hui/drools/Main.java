package com.hui.drools;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

public class Main {

	public static void main(String[] args) {
		StatefulKnowledgeSession ksession = useChangeset();
		
		//StatefulKnowledgeSession ksession = useDRL();

		String[] names = new String[] { "kitchen", "bedroom", "office",
				"livingroom" };

		Map<String, Room> name2room = new HashMap<String, Room>();

		for (String name : names) {
			Room room = new Room(name);
			name2room.put(name, room);
			ksession.insert(room);
			Sprinkler sprinkler = new Sprinkler(room);
			ksession.insert(sprinkler);

		}

		ksession.fireAllRules();
		Fire kitchenFire = new Fire(name2room.get("kitchen"));
		Fire officeFire = new Fire(name2room.get("office"));
		FactHandle kitchenFireHandle = ksession.insert(kitchenFire);
		FactHandle officeFireHandle = ksession.insert(officeFire);
		ksession.fireAllRules();
		ksession.retract(kitchenFireHandle);
		ksession.retract(officeFireHandle);
		ksession.fireAllRules();
		
		//kagent.dispose();
		ksession.getAgenda();
	}

	private static StatefulKnowledgeSession useDRL() {
		Main main = new Main();
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add( ResourceFactory.newClassPathResource( "demo.drl", main.getClass()),
		              ResourceType.DRL );

		if ( kbuilder.hasErrors() ) {
			System.err.println( kbuilder.getErrors().toString() );
			}
		
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		
		kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		return ksession;
	}

	private static StatefulKnowledgeSession useChangeset() {
		Main main = new Main();
		KnowledgeAgent kagent = KnowledgeAgentFactory
				.newKnowledgeAgent("MyAgent");
		kagent.applyChangeSet(ResourceFactory.newClassPathResource("changeset.xml", main.getClass()));
		KnowledgeBase kbase = kagent.getKnowledgeBase();

		ResourceFactory.getResourceChangeNotifierService().start();
		ResourceFactory.getResourceChangeScannerService().start();

		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		return ksession;
	}

}
