package the.md.project.SaxParsing.util;

/** Balises ou paramètres présents dans le xml. */
public enum XMLElement {
  
  /** Balise garage. */
  GARAGE("garage"),
  
  /** Balise group. */
  GROUP("group"),
  
  /** Balise vehicule. */
  VEHICULE("vehicule");
  
  /** Libelle du noeud. */
  private final String libelle;
  
  /**
   * Constructeur.
   * @param libelle
   *          le libelle de l'enum
   */
  private XMLElement(final String libelle) {
    this.libelle = libelle;
  }
  
  /**
   * Accesseur sur l'attribut libelle
   * @return String libelle
   */
  public final String getLibelle() {
    return libelle;
  }
  
  /**
   * Accesseur en lecture de la classe <code>XmlElement</code> par Nom.
   * @param libelle
   *          Le libelle.
   * @return L'objet XmlElement.
   */
  public static XMLElement getXmlElementParNom(
    final String libelle) {
    for (XMLElement type : XMLElement.values()) {
      if (type.getLibelle().equals(libelle)) {
        return type;
      }
    }
    return null;
  }
  
};