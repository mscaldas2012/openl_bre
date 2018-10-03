package com.baeldung.openltablets.rules;


import com.baeldung.openltablets.model.CatchmentArea;
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
        rules.process("Georgia", "", 17);
        rules.process("Georgia", "", 29);
        rules.process("California", "Los Angeles");
        rules.process("Alaska", "Juneau");


        //Using Model:
        System.out.println("\nWith Model...\n");
        rules.processModel(new CatchmentArea("California", "San Francisco", 12));
        rules.processModel(new CatchmentArea("California", "Alameda", 0));
        rules.processModel(new CatchmentArea("Georgia", "Fulton", 17));
        rules.processModel(new CatchmentArea("Georgia", "Fulton", 19));
        rules.processModel(new CatchmentArea("Colorado", "", 0));
        rules.processModel(new CatchmentArea("Colorado", "Denver", 7));
    }



    public void process(String state, String county, Integer age) {
        long startTime = System.currentTimeMillis();

        Boolean response = instance.validateCatchment(state, county, age);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(String.format("Processing(%s, %s, %d)= %s in %d ms.", state, county, age, response, totalTime));

    }
    public void process(String state, String county) {
        process(state, county, null);
    }

    private void processModel(CatchmentArea model) {
        Boolean response = instance.validateCatchmentModel(model)  ;

        System.out.println(String.format("Processing(%s, %s, %d)= %s", model.getState(), model.getCounty(), model.getAge(), response));
    }
}
