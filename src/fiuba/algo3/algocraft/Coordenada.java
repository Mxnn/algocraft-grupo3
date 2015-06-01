package fiuba.algo3.algocraft;
public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada(int cX, int cY){
		this.x = cX;
		this.y = cY;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getX(){
		return this.x;
	}
	
    @Override
    public boolean equals(Object otro) {
        if (this == otro)
          return true;

        if (!(otro instanceof Coordenada))
          return false;

        Coordenada otraCoor = (Coordenada) otro;
        return otraCoor.getX() == this.x && otraCoor.getY() == this.y;
    }
	
	@Override
	public int hashCode() {
	    int hash = 7;
	    hash = 71 * hash + this.x;
	    hash = 71 * hash + this.y;
	    return hash;
	}

}
