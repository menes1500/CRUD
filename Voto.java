import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;

public class Voto implements Register {
    
    protected int idVoto; 
    protected int idUsuario; 
    protected char tipo; 
    protected int idPR;
    protected boolean voto; 

    public Voto (int idVoto, int idUsuario, char tipo, int IdPR, boolean voto) {
        this.idVoto = idVoto;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.idPR = idPR;
        this.voto = voto;
    }

    public Voto() {
        this.idVoto = -1;
        this.idUsuario = -1;
        this.tipo = ' ';
        this.idPR = -1;
        this.voto = false;
    }

    public String toString(){
        return "idVoto: " + idVoto + "\nidUsuario: " + idUsuario + "\nTipo: " + tipo + "\nidPR: " + idPR + "\nVoto: " + voto;
    }

    public int getID() {
        return this.idVoto;
    }

    public void setID(int idVoto) {
        this.idVoto = idVoto;
    }

    public int getIDUsuario() {
        return this.idUsuario;
    }

    public void setIDUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public char getTipo() {
        return this.tipo;
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public int getIDPR() {
        return this.idPR;
    }

    public void setIDPR(int idPR){
        this.idPR = idPR;
    }

    public boolean getVoto() {
        return this.voto;
    }

    public void setVoto(boolean voto){
        this.voto = voto;
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            dos.writeInt(idVoto);
            dos.writeInt(idUsuario);
            dos.writeChar(tipo);
            dos.writeInt(idPR);
            dos.writeBoolean(voto);
        } catch (Exception e) {
        }

        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        try {
            this.idVoto = dis.readInt();
            this.idUsuario = dis.readInt();
            this.tipo = dis.readChar();
            this.idPR = dis.readInt();
            this.voto = dis.readBoolean();
            
        } catch (Exception e) {
        }

    }

    public String chaveSecundaria() {
        return idUsuario + "|" + tipo + "|" + idPR;
    }
}