package step_definitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("not (@OnlyAdd or (@DeleteUser and @OnlyGet))")
	public void addPlaceStub()
	{
		AutoGroupValStepDefinition stepDefs = new AutoGroupValStepDefinition();
		
		if (AutoGroupValStepDefinition.getUserId().isEmpty())
		{
			stepDefs.a_valid_add_user_apı_payload_with_data("aliboztemir@gmail.com", "Ali Boztemir");
		}
	}
}
