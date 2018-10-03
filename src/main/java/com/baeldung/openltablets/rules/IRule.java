package com.baeldung.openltablets.rules;

import com.baeldung.openltablets.model.CatchmentArea;

public interface IRule {
    Boolean validateCatchment(String state, String county, Integer age);

    Boolean validateCatchmentModel(CatchmentArea cachmentArea);

}