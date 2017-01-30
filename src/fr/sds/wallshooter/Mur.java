package fr.sds.wallshooter;

public class Wall{
	int posy;
	int posx;
	int length;
	int width;

	public Wall(){
		posy = 3;
		lenght = 1;
		width = 1;
	}

	public int getWallPosX(){
		return posx;
	}

	public int getWallPosY(){
		return posy;
	}
	
	public void setWallPosX(int x){
		posx = x;
	}
	
	public void setWallPosY(int y){
		posy = y;
	}
}
