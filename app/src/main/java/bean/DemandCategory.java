
package bean;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


    public class DemandCategory implements Serializable {

        private static final long serialVersionUID = 1L;
      
        private Long id;

//
//        private DemandCategoryValidation demandCategoryValidation;
//
//
//        private Category category;
//
//
//        private Product product;
//
//
//        private List<SotimentItem> sotimentItems;
//
//
//        private Layout layout;
//
//
//        private Katalogart katalogart;
//
//
//        private Prozess prozess;
//
//
//        private Ausgabe ausgabe;

       
//        private Schluessel Schluessel;

        private int umfang;

        //Seiten
        private int anzahlGesamtSeiten = 2;
        //10% für den ANzahl dere Seiten
        private int percentSeitenFaktor = 10;
        private int anzahlSonderSeiten = 3;
        private int anzahlGenerierungUpdateSeiten = 4;
        private int anzahlIHVZSeiten = 4;
        private int anzahlBestellNrSeiten = 5;

        //Artikel
        private int anzahlGesamtArtikel = 6;
        private int anzahlNeueArtikel = 7;
        private int anzahlBestandArtikel = 8;
        private int anzahlÜbernahmeArtikel = 9;

        //Produkt
        private int anzahlGesamtProdukt = 10;
        private int anzahlNeueProdukt = 11;
        private int anzahlBestandProdukt = 12;

        //Lieferant   
        private int anzahlLieferantGesamt = 13;
        private int anzahlLieferantNeu = 14;

        //Warengruppe Kapitel
        private int anzahlKapitetel = 15;

        private int nbrTotalValidation;


//        private CorrectionSchluessel correctionSchluessel;
//
//
//        private MitgliederkorrekturFaktor mitgliederkorrekturFaktor;
//
//
//        private WechselfassungVariantFaktor wechselfassungVariantFaktor;

        //Teilnehmerzahl
        private int teilnehmerZahl = 16;
       
//        private ParticipantFaktor participantFaktor;


//        private KonzeptbearbeitungFaktor konzeptbearbeitungFaktor;

        //Für den Druck
        private boolean druck = false;

  
//        private FormatAuswaehlen formatAuswaehlen;

        
//        private PapierMaterialAuswaehlen papierMaterialAuswaehlen;

        private int seitenanzahl = 17;

//        private Farbigkeit farbigkeit;
//        private ArtDerWeiterverarbeitung artDerWeiterverarbeitung;
//        private Veredlung veredlung;

        private boolean umschlag;

//        private UmschlagPapierAuswaehlen umschlagPapierAuswaehlen;
//
//        private UmschlagFarbigkeit umschlagFarbigkeit;
//
//        private Cover cover;
//
//        private Bindung bindung;
//
//        private Auflage auflage;

        //Date de Livraisoin
        private Date liefertermin = new Date();

        //Bearbeitungszeit
        private int bearbeitungszeit = 3;

        //Beteiligten Anzahl die die Initialcosts beinflüssen
        private int anzahlBeteiligten = 2;

        //Mitglieder Anzahl
        private int anzahlMitglieder = 20;

        //Datum falls die einzelne Preise geändert werden
        private Date dateDemandCategory = new Date();

        //Berechnete Summen 
        private BigDecimal summDruck = new BigDecimal(0);
        private BigDecimal summTotal = new BigDecimal(0);
        private List<DemandCategoryDepartementCalculation> demandCategoryDepartementCalculations;

        private User user;
        private Departement department;
        private Date dateSystem = new Date();

        public DemandCategory(Long id, Date dateDemandCategory, Departement department) {
            this.id = id;
            this.dateDemandCategory = dateDemandCategory;
            this.department = department;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Departement getDepartment() {
            return department;
        }

        public void setDepartment(Departement department) {
            this.department = department;
        }

        public Date getDateSystem() {
            return dateSystem;
        }

        public void setDateSystem(Date dateSystem) {
            this.dateSystem = dateSystem;
        }


        public List<DemandCategoryDepartementCalculation> getDemandCategoryDepartementCalculations() {
            return demandCategoryDepartementCalculations;
        }

        public void setDemandCategoryDepartementCalculations(List<DemandCategoryDepartementCalculation> demandCategoryDepartementCalculations) {
            this.demandCategoryDepartementCalculations = demandCategoryDepartementCalculations;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

//        public DemandCategoryValidation getDemandCategoryValidation() {
//            if (demandCategoryValidation == null) {
//                demandCategoryValidation = new DemandCategoryValidation();
//            }
//            return demandCategoryValidation;
//        }
//
//        public void setDemandCategoryValidation(DemandCategoryValidation demandCategoryValidation) {
//            this.demandCategoryValidation = demandCategoryValidation;
//        }

        public BigDecimal getSummDruck() {
            return summDruck;
        }

        public void setSummDruck(BigDecimal summDruck) {
            this.summDruck = summDruck;
        }

        public BigDecimal getSummTotal() {
            return summTotal;
        }

        public void setSummTotal(BigDecimal summTotal) {
            this.summTotal = summTotal;
        }

//        public Category getCategory() {
//            return category;
//        }
//
//        public void setCategory(Category category) {
//            this.category = category;
//        }
//
//        public Product getProduct() {
//            return product;
//        }
//
//        public void setProduct(Product product) {
//            this.product = product;
//        }
//
//        @XmlTransient
//        public List<SotimentItem> getSotimentItems() {
//            return sotimentItems;
//        }
//
//        public void setSotimentItems(List<SotimentItem> sotimentItems) {
//            this.sotimentItems = sotimentItems;
//        }
//
//        public Layout getLayout() {
//            return layout;
//        }
//
//        public void setLayout(Layout layout) {
//            this.layout = layout;
//        }
//
//        public Katalogart getKatalogart() {
//            return katalogart;
//        }

        public int getUmfang() {
            return umfang;
        }

        public void setUmfang(int umfang) {
            this.umfang = umfang;
        }

//        public void setKatalogart(Katalogart katalogart) {
//            this.katalogart = katalogart;
//        }
//
//        public Prozess getProzess() {
//            return prozess;
//        }
//
//        public void setProzess(Prozess prozess) {
//            this.prozess = prozess;
//        }
//
//        public Ausgabe getAusgabe() {
//            return ausgabe;
//        }
//
//        public void setAusgabe(Ausgabe ausgabe) {
//            this.ausgabe = ausgabe;
//        }
//
//        public Schluessel getSchluessel() {
//            return Schluessel;
//        }
//
//        public void setSchluessel(Schluessel Schluessel) {
//            this.Schluessel = Schluessel;
//        }

        public int getAnzahlGesamtSeiten() {
            return anzahlGesamtSeiten;
        }

        public void setAnzahlGesamtSeiten(int anzahlGesamtSeiten) {
            this.anzahlGesamtSeiten = anzahlGesamtSeiten;
        }

        public int getPercentSeitenFaktor() {
            return percentSeitenFaktor;
        }

        public void setPercentSeitenFaktor(int percentSeitenFaktor) {
            this.percentSeitenFaktor = percentSeitenFaktor;
        }

        public int getAnzahlSonderSeiten() {
            return anzahlSonderSeiten;
        }

        public void setAnzahlSonderSeiten(int anzahlSonderSeiten) {
            this.anzahlSonderSeiten = anzahlSonderSeiten;
        }

        public int getAnzahlGenerierungUpdateSeiten() {
            return anzahlGenerierungUpdateSeiten;
        }

        public void setAnzahlGenerierungUpdateSeiten(int anzahlGenerierungUpdateSeiten) {
            this.anzahlGenerierungUpdateSeiten = anzahlGenerierungUpdateSeiten;
        }

        public int getAnzahlIHVZSeiten() {
            return anzahlIHVZSeiten;
        }

        public void setAnzahlIHVZSeiten(int anzahlIHVZSeiten) {
            this.anzahlIHVZSeiten = anzahlIHVZSeiten;
        }

        public int getAnzahlBestellNrSeiten() {
            return anzahlBestellNrSeiten;
        }

        public void setAnzahlBestellNrSeiten(int anzahlBestellNrSeiten) {
            this.anzahlBestellNrSeiten = anzahlBestellNrSeiten;
        }

        public int getAnzahlGesamtArtikel() {
            return anzahlGesamtArtikel;
        }

        public void setAnzahlGesamtArtikel(int anzahlGesamtArtikel) {
            this.anzahlGesamtArtikel = anzahlGesamtArtikel;
        }

        public int getAnzahlNeueArtikel() {
            return anzahlNeueArtikel;
        }

        public void setAnzahlNeueArtikel(int anzahlNeueArtikel) {
            this.anzahlNeueArtikel = anzahlNeueArtikel;
        }

        public int getAnzahlBestandArtikel() {
            return anzahlBestandArtikel;
        }

        public void setAnzahlBestandArtikel(int anzahlBestandArtikel) {
            this.anzahlBestandArtikel = anzahlBestandArtikel;
        }

        public int getAnzahlÜbernahmeArtikel() {
            return anzahlÜbernahmeArtikel;
        }

        public void setAnzahlÜbernahmeArtikel(int anzahlÜbernahmeArtikel) {
            this.anzahlÜbernahmeArtikel = anzahlÜbernahmeArtikel;
        }

        public int getAnzahlGesamtProdukt() {
            return anzahlGesamtProdukt;
        }

        public void setAnzahlGesamtProdukt(int anzahlGesamtProdukt) {
            this.anzahlGesamtProdukt = anzahlGesamtProdukt;
        }

        public int getAnzahlNeueProdukt() {
            return anzahlNeueProdukt;
        }

        public void setAnzahlNeueProdukt(int anzahlNeueProdukt) {
            this.anzahlNeueProdukt = anzahlNeueProdukt;
        }

        public int getAnzahlBestandProdukt() {
            return anzahlBestandProdukt;
        }

        public void setAnzahlBestandProdukt(int anzahlBestandProdukt) {
            this.anzahlBestandProdukt = anzahlBestandProdukt;
        }

        public int getAnzahlLieferantGesamt() {
            return anzahlLieferantGesamt;
        }

        public void setAnzahlLieferantGesamt(int anzahlLieferantGesamt) {
            this.anzahlLieferantGesamt = anzahlLieferantGesamt;
        }

        public int getAnzahlLieferantNeu() {
            return anzahlLieferantNeu;
        }

        public void setAnzahlLieferantNeu(int anzahlLieferantNeu) {
            this.anzahlLieferantNeu = anzahlLieferantNeu;
        }

        public int getAnzahlKapitetel() {
            return anzahlKapitetel;
        }

        public void setAnzahlKapitetel(int anzahlKapitetel) {
            this.anzahlKapitetel = anzahlKapitetel;
        }

//        public CorrectionSchluessel getCorrectionSchluessel() {
//            return correctionSchluessel;
//        }
//
//        public void setCorrectionSchluessel(CorrectionSchluessel correctionSchluessel) {
//            this.correctionSchluessel = correctionSchluessel;
//        }
//
//        public MitgliederkorrekturFaktor getMitgliederkorrekturFaktor() {
//            return mitgliederkorrekturFaktor;
//        }
//
//        public void setMitgliederkorrekturFaktor(MitgliederkorrekturFaktor mitgliederkorrekturFaktor) {
//            this.mitgliederkorrekturFaktor = mitgliederkorrekturFaktor;
//        }
//
//        public WechselfassungVariantFaktor getWechselfassungVariantFaktor() {
//            return wechselfassungVariantFaktor;
//        }
//
//        public void setWechselfassungVariantFaktor(WechselfassungVariantFaktor wechselfassungVariantFaktor) {
//            this.wechselfassungVariantFaktor = wechselfassungVariantFaktor;
//        }

        public int getTeilnehmerZahl() {
            return teilnehmerZahl;
        }

        public void setTeilnehmerZahl(int teilnehmerZahl) {
            this.teilnehmerZahl = teilnehmerZahl;
        }

//        public ParticipantFaktor getParticipantFaktor() {
//            return participantFaktor;
//        }
//
//        public void setParticipantFaktor(ParticipantFaktor participantFaktor) {
//            this.participantFaktor = participantFaktor;
//        }
//
//        public KonzeptbearbeitungFaktor getKonzeptbearbeitungFaktor() {
//            return konzeptbearbeitungFaktor;
//        }
//
//        public void setKonzeptbearbeitungFaktor(KonzeptbearbeitungFaktor konzeptbearbeitungFaktor) {
//            this.konzeptbearbeitungFaktor = konzeptbearbeitungFaktor;
//        }

        public boolean isDruck() {
            return druck;
        }

        public void setDruck(boolean druck) {
            this.druck = druck;
        }

//        public FormatAuswaehlen getFormatAuswaehlen() {
//            return formatAuswaehlen;
//        }
//
//        public void setFormatAuswaehlen(FormatAuswaehlen formatAuswaehlen) {
//            this.formatAuswaehlen = formatAuswaehlen;
//        }
//
//        public PapierMaterialAuswaehlen getPapierMaterialAuswaehlen() {
//            return papierMaterialAuswaehlen;
//        }
//
//        public void setPapierMaterialAuswaehlen(PapierMaterialAuswaehlen papierMaterialAuswaehlen) {
//            this.papierMaterialAuswaehlen = papierMaterialAuswaehlen;
//        }

        public int getSeitenanzahl() {
            return seitenanzahl;
        }

        public void setSeitenanzahl(int seitenanzahl) {
            this.seitenanzahl = seitenanzahl;
        }

//        public Farbigkeit getFarbigkeit() {
//            return farbigkeit;
//        }
//
//        public void setFarbigkeit(Farbigkeit farbigkeit) {
//            this.farbigkeit = farbigkeit;
//        }
//
//        public ArtDerWeiterverarbeitung getArtDerWeiterverarbeitung() {
//            return artDerWeiterverarbeitung;
//        }
//
//        public void setArtDerWeiterverarbeitung(ArtDerWeiterverarbeitung artDerWeiterverarbeitung) {
//            this.artDerWeiterverarbeitung = artDerWeiterverarbeitung;
//        }
//
//        public Veredlung getVeredlung() {
//            return veredlung;
//        }
//
//        public void setVeredlung(Veredlung veredlung) {
//            this.veredlung = veredlung;
//        }

        public boolean isUmschlag() {
            return umschlag;
        }

        public void setUmschlag(boolean umschlag) {
            this.umschlag = umschlag;
        }

//        public UmschlagPapierAuswaehlen getUmschlagPapierAuswaehlen() {
//            return umschlagPapierAuswaehlen;
//        }
//
//        public void setUmschlagPapierAuswaehlen(UmschlagPapierAuswaehlen umschlagPapierAuswaehlen) {
//            this.umschlagPapierAuswaehlen = umschlagPapierAuswaehlen;
//        }
//
//        public UmschlagFarbigkeit getUmschlagFarbigkeit() {
//            return umschlagFarbigkeit;
//        }
//
//        public void setUmschlagFarbigkeit(UmschlagFarbigkeit umschlagFarbigkeit) {
//            this.umschlagFarbigkeit = umschlagFarbigkeit;
//        }
//
//        public Cover getCover() {
//            return cover;
//        }
//
//        public void setCover(Cover cover) {
//            this.cover = cover;
//        }
//
//        public Bindung getBindung() {
//            return bindung;
//        }
//
//        public void setBindung(Bindung bindung) {
//            this.bindung = bindung;
//        }
//
//        public Auflage getAuflage() {
//            return auflage;
//        }
//
//        public void setAuflage(Auflage auflage) {
//            this.auflage = auflage;
//        }

        public Date getLiefertermin() {
            return liefertermin;
        }

        public void setLiefertermin(Date liefertermin) {
            this.liefertermin = liefertermin;
        }

        public int getBearbeitungszeit() {
            return bearbeitungszeit;
        }

        public void setBearbeitungszeit(int bearbeitungszeit) {
            this.bearbeitungszeit = bearbeitungszeit;
        }

        public int getAnzahlBeteiligten() {
            return anzahlBeteiligten;
        }

        public void setAnzahlBeteiligten(int anzahlBeteiligten) {
            this.anzahlBeteiligten = anzahlBeteiligten;
        }

        public int getAnzahlMitglieder() {
            return anzahlMitglieder;
        }

        public void setAnzahlMitglieder(int anzahlMitglieder) {
            this.anzahlMitglieder = anzahlMitglieder;
        }

        public Date getDateDemandCategory() {
            return dateDemandCategory;
        }

        public void setDateDemandCategory(Date dateDemandCategory) {
            this.dateDemandCategory = dateDemandCategory;
        }

        public int getNbrTotalValidation() {
            return nbrTotalValidation;
        }

        public void setNbrTotalValidation(int nbrTotalValidation) {
            this.nbrTotalValidation = nbrTotalValidation;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (id != null ? id.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof DemandCategory)) {
                return false;
            }
            DemandCategory other = (DemandCategory) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "bean.DemandCategory[ id=" + id + " ]";
        }

    }

