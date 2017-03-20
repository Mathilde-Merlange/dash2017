package dash;

import java.util.*;

public class Niveau {
private String name;
private int caveDelay;
private int caveTime;
private int diamondsRequired;
private int[] diamondValue;
private int amoebaTime;
private int magicWallTime;
private int largeur;
private int hauteur;
private char[][] carte;
private Rockford rockford;

public Rockford getRockford() {
	return rockford;
}

public void setRockford(Rockford rockford) {
	this.rockford = rockford;
}

public char[][] getCarte() {
	return carte;
}

public void setCarte(char[][] carte) {
	this.carte = carte;
}

public Niveau(String name, int caveDelay, int caveTime, int diamondsRequired, int[] diamondValue, int amoebaTime, int magicWallTime, int largeur, int hauteur){
	this.name=name;
	this.caveDelay=caveDelay;
	this.caveTime=caveTime;
	this.diamondsRequired=diamondsRequired;
	this.diamondValue=diamondValue;
	this.amoebaTime=amoebaTime;
	this.magicWallTime=magicWallTime;
	this.largeur=largeur;
	this.hauteur=hauteur;
	carte= new char[this.largeur][this.hauteur] ;
}

public Niveau(){
	this.name="Cave 1";
	this.caveDelay=6;
	this.caveTime=150;
	this.diamondsRequired=3;
	this.diamondValue=new int[]{30,15};
	this.amoebaTime=135;
	this.magicWallTime=6;
	this.largeur=40;
	this.hauteur=22;
	carte= new char[this.largeur][this.hauteur] ;
	this.rockford=new Rockford();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCaveDelay() {
	return caveDelay;
}
public void setCaveDelay(int caveDelay) {
	this.caveDelay = caveDelay;
}
public int getCaveTime() {
	return caveTime;
}
public void setCaveTime(int caveTime) {
	this.caveTime = caveTime;
}
public int getDiamondsRequired() {
	return diamondsRequired;
}
public void setDiamondsRequired(int diamondsRequired) {
	this.diamondsRequired = diamondsRequired;
}
public int[] getDiamondValue() {
	return diamondValue;
}
public void setDiamondValue(int[] diamondValue) {
	this.diamondValue = diamondValue;
}
public int getAmoebaTime() {
	return amoebaTime;
}
public void setAmoebaTime(int amoebaTime) {
	this.amoebaTime = amoebaTime;
}
public int getMagicWallTime() {
	return magicWallTime;
}
public void setMagicWallTime(int magicWallTime) {
	this.magicWallTime = magicWallTime;
}
}
