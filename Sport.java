public class Sport {
    private String nom;
    private int nbJoueur;
    private boolean typeSp;
    
    public Sport(String nom, int nbJoueur, boolean typeSp) {
        this.nom = nom;
        this.nbJoueur = nbJoueur;
        this.typeSp = typeSp;
    }
    
    @Override
    public String toString() {
        return "Sport [nom=" + nom + ", nbJoueur=" + nbJoueur + ", typeSp=" + typeSp + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sport autreSport = (Sport) obj;
        return nbJoueur == autreSport.nbJoueur &&
                typeSp == autreSport.typeSp &&
                Objects.equals(nom, autreSport.nom);
    }
    
    @Override
    public Sport clone() {
        try {
            return (Sport) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Le clonage est supporté, cette exception ne devrait pas être levée.", e);
        }
    }
    @Override
    public int compareTo(Sport autreSport) {
        return Integer.compare(this.nbJoueur, autreSport.nbJoueur);
    }
}
public class Lance_poids extends Sport{
    
      private Sport[] tableauSports;

    public Lance_poids(int taille) {
        tableauSports = new Sport[taille];
    }
     public Lance_poids(Sport[] sports) {
        this.tableauSports = sports;
    }
     public void trierTableau() {
        Arrays.sort(tableauSports);
    }
       public void supprimerSport(int index) {
        if (index < 0 || index >= tableauSports.length) {
            System.out.println("Index invalide. Veuillez fournir un index valide.");
            return;
        }
        Sport[] nouveauTableau = new Sport[tableauSports.length - 1];
        System.arraycopy(tableauSports, 0, nouveauTableau, 0, index);
        System.arraycopy(tableauSports, index + 1, nouveauTableau, index, tableauSports.length - index - 1);
        tableauSports = nouveauTableau;
    }
    public int compterElements() {
        return tableauSports.length;
    }
     public void inverserOrdre() {
        Arrays.reverse(tableauSports);
    }
    public void afficherTableau() {
        System.out.println(Arrays.toString(tableauSports));
    }
    public Sport elementLePlusGrand() {
       for (Sport sport : tableauSports) {
            if (sport.compareTo(plusGrand) > 0) {
                plusGrand = sport;
            }
        }
        }
    public static boolean testerEgaliteTableaux(Sport[] tableau1, Sport[] tableau2) {
         if (tableau1 == null && tableau2 == null) {
            return true;
        }
        if (tableau1 == null || tableau2 == null) {
            return false;
        }
        return Arrays.equals(tableau1, tableau2);
    }
    
}

public class ConteneurDeSports<T extends Sport> implements Iterable<T>{
    private List<T> listeSports;

    public ConteneurDeSports() {
        this.listeSports = new ArrayList<>();
    }

    public void ajouterSport(T sport) {
        listeSports.add(sport);
    }

    public void supprimerSport(T sport) {
        listeSports.remove(sport);
    }

    public List<T> getListeSports() {
        return listeSports;
     public void alimenterListe(List<T> nouveauxSports) {
        listeSports.addAll(nouveauxSports);
    }
     public void afficherListe() {
        for (T sport : listeSports) {
            System.out.println(sport);
        }
    }
     public void parcourirListe() {
        Iterator<T> it = listeSports.iterator();
        while (it.hasNext()) {
            T sport = it.next();
            System.out.println(sport);
        }
    }
    public void insererElement(T sport, int position) {
    if (position < 0 || position > listeSports.size()) {
            System.out.println("Position invalide. Veuillez fournir une position valide.");
            return;
        }
        listeSports.add(position, sport);
    }

    }
