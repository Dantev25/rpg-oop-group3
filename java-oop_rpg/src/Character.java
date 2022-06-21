
public class Character{
	
	public String getName() {
        return name;
    }
	
    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
    
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
    public void display(){
        System.out.println("Name = "+name+"Strength = "+strength+"Max health = "+health+"Defence = "+def);
    }

    public Character(String name,int strength,int health,int def, int mp){
       this.name = name;
       this.strength = strength;
       this.health = health;
       this.def=def;
       this.mp=mp;
    }

    private  String name;
    private  int strength;
    private  int health;
    private  int def;
    private	 int mp;
}
