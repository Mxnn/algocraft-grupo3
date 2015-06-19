package fiuba.algo3.algocraft.modelo.mapa;

import java.util.ArrayList;

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
	
	public int distanciaConCoordenada(Coordenada otra){
		int distX = Math.abs(this.getX() - otra.getX());
		int distY = Math.abs(this.getY() - otra.getY());
		return Math.max(distX, distY);
			
	}
	
	public ArrayList<Coordenada> obtenerCoordenadasVecinas() {
        ArrayList<Coordenada> coordenadasVecinas = new ArrayList<Coordenada>();

        for (int x = this.x - 1; x <= this.x + 1 ; x++)
            for (int y = this.y - 1; y <= this.y + 1 ; y++) {
                if (x == this.x && y == this.y)
                    continue;

                coordenadasVecinas.add(new Coordenada(x, y));
            }

        return coordenadasVecinas;
    }

    @Override
    public boolean equals(Object otro) 
    {
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

	public Coordenada calcularCoordenadaSiguiente( Coordenada coordenadaDeDestinacion) {
		Coordenada coordenadaSiguiente = new Coordenada(coordenadaDeDestinacion.getX()-this.getX(),coordenadaDeDestinacion.getY()-this.getY());
		if (!coordenadaSiguiente.equals(new Coordenada(0,0))){

			if(Math.abs(coordenadaSiguiente.getX())>Math.abs(coordenadaSiguiente.getY())){
				int direccion =this.darDireccion(coordenadaSiguiente.getX());
				coordenadaSiguiente= new Coordenada(this.x+direccion,this.y);
			}else{
				int direccion =this.darDireccion(coordenadaSiguiente.getY());
				coordenadaSiguiente= new Coordenada(this.x,this.y+direccion);
			}
		}
		return coordenadaSiguiente;
	}



	private int darDireccion(int x) {
		if(x>0){
			return 1;
		}else{
			return -1;
		}
	}

}
