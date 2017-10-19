package arrays;

public class ObjectArrays {
	
	public ObjectArrays() {
		Person[] people = new Person[20];
		populate(people);
		//people[0] = new Thing("coffee maker");
		for(Object p : people) {
			System.out.println(p);
		}
		Person[]group = selectGroup(people, 4);
		System.out.println(Person.toString(group));
	}

	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			//BIG IDEA!!!
			//In Object[] (but not primitive arrays like int[] or double[])
			//You can have multiple data types(sub-classes of the declared type)
			if(Math.random() < .6) {
				//60% of time is a student
				int grade = (int)(Math.random()*5)+9;
				people[i] = new Student(firstName,lastName,b, grade);
			}else
			{
				//40% of the time is normal person
				people[i] = new Person(firstName, lastName, b);
			}
		}
	}
	public double countDifferences(Person[] arr1, Person[] arr2) {
		double numDiff = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				numDiff ++;
			}
		}
		return numDiff;
	}
	public void testShuffling() {
		double sum;
		for(int i =0; i < 100; i++) {
			sum += countDifferences(Person[] arr1, Person[] arr2);
		}
		System.out.println(sum/100); 
	}
	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int) (Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}
	private Person[] selectGroup(Person[] population,int length) {
		Person[] arr = new Person[length];
		int randNum = 0;
		for(int i = 0; i < population.length; i++) {
			randNum = (int)(Math.random()*(population.length+1));
			arr[i] = population[randNum];
			for(Person value: arr) {
				if(value == population[randNum]) {
					randNum = (int)(Math.random()*(population.length+1));
					arr[i] = population[randNum];
					break;
				}
			}
			
		}
		return arr; 
		//Person[] group = new Person[length];
		//group[0] = selectAPerson(population);
		//for(int i = 1; i < length; i++) {
			
		//}
	} 
}
