import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas{
    
    public void cria(InputStream inputStream, String titulo) throws Exception{

        // leitura da imagem
        //InputStream inputStream =  new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 40;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.SCALE_SMOOTH);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D)  novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 52);
        graphics.setColor(Color.WHITE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString(titulo, 20, novaAltura - 30);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + titulo + ".png"));
    }

}
