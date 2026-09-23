package cartes;

public enum Type {

	FEU("Feu Rouge","Feu Vert", "Propriétaire"),
	ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "As du volant");
	
	private final String nomAttaque;
	private final String nomParade;
	private final String nomBotte;
	
	Type(String nomAttaque, String nomParade, String nomBotte){
		this.nomAttaque= nomAttaque;
		this.nomParade= nomParade;
		this.nomBotte= nomBotte;
		
	}
	
	public String getNomAttaque() {
		return nomAttaque;
	}
	public String getNomParade() {
		return nomParade;
	}
	public String getNomBotte() {
		return nomBotte;
	}
	
}
