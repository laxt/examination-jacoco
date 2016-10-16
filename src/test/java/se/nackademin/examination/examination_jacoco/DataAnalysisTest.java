package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DataAnalysisTest {

	DataAnalysis dataAnalysis = new DataAnalysis();
	ArrayList<String> values = new ArrayList<String>();

	@Test
	public void test_SmallerFirstName_Under30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "25", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The first name is smaller or equals in size to the last name and the participant is 30 or younger' ",
				result.contains("The first name is smaller or equals in size to the last name and the participant is 30 or younger"));
	}
	
	@Test
	public void test_SmallerFirstName_Exact30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "30", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The first name is smaller or equals in size to the last name and the participant is 30 or younger' ",
				result.contains("The first name is smaller or equals in size to the last name and the participant is 30 or younger"));
	}

	
	
	
	@Test
	public void test_SmallerFirstName_Over30() {
		values.addAll(Arrays.asList("test", "Leonardo", "Dicaprio", "M", "35", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'No analysis was performed' ",
				result.contains("No analysis was performed"));
	}

	
	@Test
	public void test_GreaterFirstName_Over30() {
		values.addAll(Arrays.asList("Test", "Rafael", "Silva", "M", "35", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The first name is greater or equals in size to the last name and the participant older than 30' ",
				result.contains("The first name is greater or equals in size to the last name and the participant older than 30"));
	}

	@Test
	public void test_GreaterFirstName_Under30() {
		values.addAll(Arrays.asList("Test", "Rafael", "Silva", "M", "25", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'No analysis was performed' ",
				result.contains("No analysis was performed"));
	}
	

	@Test
	public void test_BigCity_Over30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "31", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The name of the homecity is big and the participant is 30 or older' ",
				result.contains("The name of the homecity is big and the participant is 30 or older"));
	}

	@Test
	public void test_BigHomeCity_Under30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "25", "Titanic"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The name of the homecity is big and the participant is younger than 30' ",
				result.contains("The name of the homecity is big and the participant is younger than 30"));		
	}

	@Test
	public void test_SmallHomeCity_Over30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "35", "HJ45"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The name of the homecity is small and the participant is 30 or older' ",
				result.contains("The name of the homecity is small and the participant is 30 or older"));		
	}

	@Test
	public void test_SmallHomeCity_Under30() {
		values.addAll(Arrays.asList("Test", "Leonardo", "Dicaprio", "M", "25", "U32"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The name of the homecity is small and the participant is younger than 30' ",
				result.contains("The name of the homecity is small and the participant is younger than 30"));		
	}
}
	
	

