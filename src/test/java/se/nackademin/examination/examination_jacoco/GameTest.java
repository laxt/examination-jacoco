package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GameTest {

	
	Game game = new Game();

	@Test

	public void test_GetGender() {
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "30", "Titanic"));
		assertEquals(game.getGenderFromInputValues(values), 'M');
	}
 
	@Test
	public void test_GetAge() {
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "30", "Titanic"));
		assertEquals(game.getAgeFromInputValues(values), 30);
	}

	@Test
	public void test_CalculateNameOutput() {
		int i = game.calculateOutPutBasedOnNames("Leon", "Dicaprio");
		assertEquals("The result should be 0", i, 0);
		i = game.calculateOutPutBasedOnNames("Leonardoo", "Dicaprio");
		assertEquals("The result should be 1", i, 1);
		i = game.calculateOutPutBasedOnNames("Leonardo", "Dicaprio");
		assertEquals("The result should be 2", i, 2);
	}

	@Test
	public void test_CalculateGenderOutput() {
		int i = game.calculateOutPutBasedOnGender('M');
		assertEquals("The result should be 0", i, 0);
		i = game.calculateOutPutBasedOnGender('F');
		assertEquals("The result should be 1", i, 1);
		i = game.calculateOutPutBasedOnGender('X');
		assertEquals("The result should be 1", i, 2);
	}

	@Test
	public void test_CalculateAgeOutput() {
		int i = game.calculateOutPutBasedOnAge(25);
		assertEquals("The result should be 0", i, 0);
		i = game.calculateOutPutBasedOnAge(26);
		assertEquals("The result should be 1", i, 1);
	}

	@Test
	public void test_CalculateHomeCityOutput() {
		int i = game.calculateOutPutBasedOnHomeCity("Amsterdam");
		assertEquals("The result should be 0", i, 0);
		i = game.calculateOutPutBasedOnHomeCity("Berlin");
		assertEquals("The result should be 1", i, 1);
		i = game.calculateOutPutBasedOnHomeCity("Copenhagen");
		assertEquals("The result should be 1", i, 2);
		i = game.calculateOutPutBasedOnHomeCity("Dartford");
		assertEquals("The result should be 1", i, 3);
		i = game.calculateOutPutBasedOnHomeCity("Eskilstuna");
		assertEquals("The result should be 1", i, 4);
		i = game.calculateOutPutBasedOnHomeCity("Florida");
		assertEquals("The result should be 1", i, 5);
		i = game.calculateOutPutBasedOnHomeCity("Gothenberg");
		assertEquals("The result should be 1", i, 6);
		i = game.calculateOutPutBasedOnHomeCity("Helsinki");
		assertEquals("The result should be 1", i, 7);
		i = game.calculateOutPutBasedOnHomeCity("Istanbul");
		assertEquals("The result should be 1", i, 8);
		i = game.calculateOutPutBasedOnHomeCity("Jakarta");
		assertEquals("The result should be 1", i, 9);
		i = game.calculateOutPutBasedOnHomeCity("Malmo");
		assertEquals("The result should be 1", i, 10);
	}

	@Test
	public void test_BuildFinalString() {
		Conversor conversor = new Conversor();
		ResultFromInputs result = new ResultFromInputs();
		result.setResultForAge(1);
		result.setResultForGender(0);
		result.setResultForHomeCity(5);
		result.setResultForNameLenght(1);
		game.buildFinalString("Leonardo", "Dicaprio", result, conversor);
	}

	@Test
	public void test_RunGame() {
		game.runGame("Test", "Leonardo", "Dicaprio", 'M', 25, "Titanic");
	}
	
	@Test
	public void test_Run() {
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "25", "Titanic"));
		game.run(values);
	}

}


