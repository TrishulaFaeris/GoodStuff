package classNotes1129;

public class Pokemon {
	
	int level;
	int hp;
	String name;
	boolean poisoned;
	
	public Pokemon(String name, int level) {
		this.name = name;
		this.level  = level;
		hp = 100;
		poisoned = false;
		
	}
	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHP();
		 target.setHP(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
		 target.setPoisoned(true);
		 }
		 });
		 squirtle.lapse();
		 bulbasaur.lapse();
		 
		 }
	public void iChooseYou() {
		System.out.println(name+ ","+name);
	}
	public int getHP() {
		return hp;
	}
	public void setHP(int newHp) {
		hp = newHp;
	}
	public void setPoisoned(boolean b) {
		poisoned = b;
	}
	public void lapse() {
		if(poisoned) {
			hp = hp - 15;
		}
	}
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}

}

