package com.baeldung.openltablets.rules;


import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;

public class Main {
    private static IRule instance;

    public static void main(String[] args) {
        Main rules = new Main();
        final EngineFactory<IRule> engineFactory = new RulesEngineFactory<IRule>(Main.class.getClassLoader()
                .getResource("openltablets/catchment.xlsx"), IRule.class);
        instance = engineFactory.newEngineInstance();

        rules.process("California", "San Francisco");
        rules.process("California", "Alameda");
        rules.process("Georgia", "");
        rules.process("California", "Los Angeles");
        rules.process("Alaska", "Juneau");
    }

    public void process(String state, String county) {
        String response = instance.validateCatchement(state, county);
        System.out.println("response = " + response);
    }
}
