import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class ManClass {

	public static void main(String args[]) {
		
		MepClass mapClass = new MepClass("sai", 16);
		try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
          //  Message message = new Message();
           // message.setMessage("Hello World");
          //  message.setStatus(Message.HELLO);
            ksession.insert(mapClass);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
		
	}
	private static KnowledgeBase readKnowledgeBase() throws Exception {
	    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	    kbuilder.add(ResourceFactory.newClassPathResource("SampleDrool.drl"), ResourceType.DRL);
	    KnowledgeBuilderErrors errors = kbuilder.getErrors();
	    if (errors.size() > 0) {
	        for (KnowledgeBuilderError error: errors) {
	            System.err.println(error);
	        }
	        throw new IllegalArgumentException("Could not parse knowledge.");
	    }
	    KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	    return kbase;
	}
}
