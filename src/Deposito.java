import java.util.Set;
import java.util.HashSet;

public class Deposito {
    private String nome; 
    private String indirizzo;
    private Set<Treno> treni;

    

    public Deposito() {}

    public Deposito(String nome, String indirizzo) { // non passo la lista nei parametri così viene inizializzata vuota
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.treni = new HashSet<>();
    }

    // Metodi GET/SET   
    // Nome

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Indirizzo

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    // Treno

    public Set<Treno> getTreni() {
        return treni;
    }

    public void setTreni(Set<Treno> treni) {
        this.treni = treni;
    }

    // MIEI METODI
    // Metodo per l'aggiunta  di treni al deposito !
    public void aggiungiTreno(Treno t) {
        // for (Treno tr : treni) {
        //     if(t.getMatricola().equals(tr.getMatricola())) {
        //         System.out.println("La matricola è già presente nel deposito! Il treno non verrà aggiunto");
        //     }
        // }
        // treni.add(t);
        // System.out.println("\n[+] Treno aggiunto con successo!");

        // PROBLEMA DEL CODICE SCRITTO NELLE RIGHE PRECEDENTI: Il metodo prima fa il controllo e stampa la frase, 
        //ma poi aggiunge lo stesso il treno nel hashset, anche se è già presente. Il treno non risulta comunque nel Set, 
        // essendo la natura delle HashSet non prevedere duplicati
        
        if (treni.contains(t)) {
            System.out.println("Treno già presente in deposito!");
        } else {
            treni.add(t);
            System.out.println("Treno aggiunto con successo!");
        }
                
    }

    // Metodo per la rimozione di treni dal deposito RIVEDEREEEEE!!!!
    public void rimuoviTreno(String matr) {
       for (Treno treno : treni) {
        if (treno.getMatricola().equals(matr)) {
            treni.remove(treno);
            break;
        }
       }
    }

    // Metodo per la ricerca di treni in deposito
    public void cercaTreno(String matrDaCercare) {
        Treno trovato = null;
        for (Treno t : treni) {
            if (t.getMatricola().equals(matrDaCercare)) {
                trovato = t;
                break;
            }
        }
        if (trovato != null) {
            System.out.println("Trovato il seguente treno:\n" + trovato);
        } else {
            System.out.println("Nessun treno con matricola " + matrDaCercare);
        }
    }

    @Override
    public String toString() {
        return "\n=== INFO DEPOSITO ===" + "\nNome: " + nome + "\nIndirizzo=" + indirizzo + "\nTreni=" + treni;
    }
}

