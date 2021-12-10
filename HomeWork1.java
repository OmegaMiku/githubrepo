class HomeWork1 {
	    public static void main(String[] args) {
	    printThreeWords();
		checkHomework();
		printColor();
		compareNumbers();
    }
	
	static void printThreeWords() {
        System.out.println("Orange");
		System.out.println("Banana");
		System.out.println("Apple");
	}
	
	static void checkHomework() {
		int a = 0;
		int b = -10;
		System.out.println("Sum is " + (a + b >= 0? "positive" : "negative"));
	}
	
	static void printColor() {
		int value = 7;
	    
	    if (value <= 0){
			System.out.println("Red");
		} else if (value > 0 && value <= 100) {
			System.out.println("Yellow");
		} else if (value > 100) {
			System.out.println("Green");
		}	
    }
	
	static void compareNumbers() {
		int a = 105;
		int b = 100;
		System.out.println(a >= b? "a >= b" : "a < b");
    }	
}

	