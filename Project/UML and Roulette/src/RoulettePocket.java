public class RoulettePocket {
	private int RouletteWheelGame;
	
	//---------------//
	//  Constructor  //
	//---------------//
	public RoulettePocket(int RouletteWheel) {
		RouletteWheelGame = RouletteWheel;
	}
	
	//  ---------------------------------------------//
	//  Calculation to get the color for the number  //
	//-----------------------------------------------//
	public String getPocketColor() {
		if (RouletteWheelGame == 0) {
			return "green";
		} else if (RouletteWheelGame >= 1 && RouletteWheelGame <= 36) {
			//   Grouping pockets that share the same pattern  //
			boolean isEven = RouletteWheelGame % 2 == 0;
			
			if ((RouletteWheelGame >= 1 && RouletteWheelGame <= 10) || (RouletteWheelGame >= 19 && RouletteWheelGame <= 28)) {
				return isEven ? "black" : "red";
			} else {
				return isEven ? "red" : "black";
			}
		} else {
			return "Error"; //   If the inputed number is not in range  //
		}
	}
}